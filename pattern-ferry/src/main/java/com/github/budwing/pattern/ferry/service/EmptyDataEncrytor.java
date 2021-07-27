package com.github.budwing.pattern.ferry.service;

import java.io.File;
import java.util.List;

public class EmptyDataEncrytor implements DataEncryptor {

	public boolean encrypt(List<File> files) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean scanVirus(List<File> files) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean scanTrojan(List<File> files) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean otherCheck(List<File> files) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
