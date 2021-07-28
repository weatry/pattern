package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.service.DataEncryptor;
import com.github.budwing.pattern.ferry.vo.FerryRequest;
import org.apache.log4j.Logger;

import static com.github.budwing.pattern.ferry.vo.FerryStatus.ERROR;
import static com.github.budwing.pattern.ferry.vo.FerryStatus.getStatus;

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
		boolean result = false;
		try {
			result = dataEncryptor.encrypt(request);
		} catch (Exception e) {
			request.setStatus(getStatus(ERROR));
			logger.error("数据校验时出错："+e);
			throw e;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("验证"+request.getRequestId()+"的数据结束！"); 
		}
		
		return result;
	}

}
