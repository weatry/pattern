package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.service.DataEncryptor;
import com.github.budwing.pattern.ferry.vo.FerryRequest;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

import static com.github.budwing.pattern.ferry.vo.FerryStatus.*;

public class EncryptingProcessor extends ExportProcessor {
	private static final Logger logger = Logger.getLogger(EncryptingProcessor.class);
	private DataEncryptor dataEncryptor;
	
	public DataEncryptor getDataEncryptor() {
		return dataEncryptor;
	}

	public void setDataEncryptor(DataEncryptor dataEncryptor) {
		this.dataEncryptor = dataEncryptor;
	}

	public boolean doProcess(FerryRequest request) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("正在验证请求"+request.getRequestId()+"的数据！"); 
		}
		List<File> ferryDataFiles = request.getBurningFiles();
		request.setStatus(getStatus(SCAN_VIRUS));
		try {
			if(dataEncryptor.scanVirus(ferryDataFiles)) {
				if(dataEncryptor.scanTrojan(ferryDataFiles)) {
					request.setStatus(getStatus(ENCRYPTING));
					if (logger.isDebugEnabled()) {
						logger.debug("验证"+request.getRequestId()+"的数据结束！"); 
					}
					return dataEncryptor.encrypt(ferryDataFiles);
				} else {
					request.setStatus(getStatus(ENCRYPT_FAIL));
				}
			} else {
				request.setStatus(getStatus(SCAN_VIRUS_FAIL));
			}
		} catch (Exception e) {
			request.setStatus(getStatus(ERROR));
			logger.error("数据校验时出错："+e);
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("验证"+request.getRequestId()+"的数据出现问题，可能存在病毒！"); 
		}
		
		return true;
	}

}
