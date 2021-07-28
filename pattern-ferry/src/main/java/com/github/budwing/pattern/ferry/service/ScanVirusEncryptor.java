package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.io.File;
import java.util.List;

import static com.github.budwing.pattern.ferry.vo.FerryStatus.*;

public class ScanVirusEncryptor implements DataEncryptor {
	private DataEncryptor encryptor = new NullEncryptor();

	public ScanVirusEncryptor(DataEncryptor encryptor) {
		super();
		this.encryptor = encryptor;
	}

	public boolean encrypt(FerryRequest request) throws Exception {

		request.setStatus(getStatus(SCAN_VIRUS));
		if (!hasVirus(request.getBurningFiles())) {
			return encryptor.encrypt(request);
		} else {
			request.setStatus(getStatus(SCAN_VIRUS_FAIL));
		}

		return false;
	}

	public boolean hasVirus(List<File> files) throws Exception {
		return false;
	}
}
