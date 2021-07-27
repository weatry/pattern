package com.github.budwing.pattern.ferry.service;

import java.io.File;
import java.util.List;

public interface DataEncryptor {
	/**
	 * 将传入的文件加密，并且用加密后的文件覆盖原文件
	 * @param files 需要加密的文件
	 * @return 加密是否成功
	 * @throws Exception 
	 */
	public boolean encrypt(List<File> files) throws Exception;
	
	/**
	 * 将传入的文件扫描，是否存在病毒
	 * @param files
	 * @return 是否存在病毒
	 * @throws Exception 病毒信息可以通过异常的形式返回
	 */
	public boolean scanVirus(List<File> files) throws Exception;
	
	public boolean scanTrojan(List<File> files) throws Exception;
	
	public boolean otherCheck(List<File> files) throws Exception;
}
