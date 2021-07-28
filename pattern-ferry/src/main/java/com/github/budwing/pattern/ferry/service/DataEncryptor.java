package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

public interface DataEncryptor {
	/**
	 * 将传入的文件加密，并且用加密后的文件覆盖原文件
	 * @param request 需要加密的文件
	 * @return 加密是否成功
	 * @throws Exception 
	 */
	public boolean encrypt(FerryRequest request) throws Exception;
	
}
