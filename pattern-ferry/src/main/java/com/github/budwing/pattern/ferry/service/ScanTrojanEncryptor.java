package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.io.File;
import java.util.List;

import static com.github.budwing.pattern.ferry.vo.FerryStatus.*;

public class ScanTrojanEncryptor implements DataEncryptor {
	private DataEncryptor encryptor;

	public ScanTrojanEncryptor(DataEncryptor encryptor) {
		super();
		this.encryptor = encryptor;
	}

	public boolean encrypt(FerryRequest request) throws Exception {
		request.setStatus(getStatus(SCAN_VIRUS));
		if(!hasTrojan(request.getBurningFiles())) {
			if (encryptor!=null) {
				return encryptor.encrypt(request);
			} else {
				return true;
			}
		} else {
			request.setStatus(getStatus(SCAN_VIRUS_FAIL));
		}
		
		return false;
	}
	
	public boolean hasTrojan(List<File> files) throws Exception {
		return false;
	}
}
