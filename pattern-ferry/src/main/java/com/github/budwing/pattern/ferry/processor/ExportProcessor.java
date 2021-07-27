package com.github.budwing.pattern.ferry.processor;

import com.github.budwing.pattern.ferry.service.FerryRequestService;
import com.github.budwing.pattern.ferry.vo.FerryRequest;

/**
 * 导出数据的处理类
 */
public abstract class ExportProcessor {
	protected String suffix = ".ferry";
	protected Long partitionSize = 734003200l; //默认700M
	protected FerryRequestService ferryRequestService;

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getPartitionSize() {
		return partitionSize;
	}

	public void setPartitionSize(Long partitionSize) {
		this.partitionSize = partitionSize;
	}

	public FerryRequestService getFerryRequestService() {
		return ferryRequestService;
	}

	public void setFerryRequestService(FerryRequestService ferryRequestService) {
		this.ferryRequestService = ferryRequestService;
	}

	/**
	 * 收集数据
	 * @param request
	 * @throws Exception
	 */
	public abstract boolean collect(FerryRequest request) throws Exception;
	
	/**
	 * 对已经收集好的数据进行加密等工作
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public abstract boolean encrypt(FerryRequest request) throws Exception;
	
	/**
	 * 分块，返回true，代表应予以立即刻录；反之，不发起刻录请求。
	 * @param request
	 * @throws Exception
	 */
	public abstract boolean partition(FerryRequest request) throws Exception;
	
	/**
	 * 向驱动发出刻录指令
	 * @param request
	 * @throws Exception
	 */
	public abstract void burning(FerryRequest request) throws Exception;
	
	public abstract String getExportCachePath();
	
}
