package com.github.budwing.pattern.ferry.service;


import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.io.File;
import java.util.List;

import static com.github.budwing.pattern.ferry.vo.FerryStatus.*;

public class DataDESEncryptor implements DataEncryptor {
	private DataEncryptor encryptor;
	
	public DataDESEncryptor() {
		super();
	}

	public DataDESEncryptor(DataEncryptor encryptor) {
		super();
		this.encryptor = encryptor;
	}

	public boolean encrypt(FerryRequest request) throws Exception {
		request.setStatus(getStatus(ENCRYPTING));
		if(encrypt(request.getBurningFiles())) {
			if (encryptor!=null) {
				return encryptor.encrypt(request);
			} else {
				return true;
			}
		} else {
			request.setStatus(getStatus(ENCRYPT_FAIL));
			return false;
		}
		
	}
	
	public boolean encrypt(List<File> files) throws Exception {
		System.out.println("do some des encrypt!");
		return true;
	}
}
