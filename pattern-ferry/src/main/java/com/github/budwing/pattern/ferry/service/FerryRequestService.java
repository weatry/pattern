package com.github.budwing.pattern.ferry.service;

import com.github.budwing.pattern.ferry.vo.FerryRequest;

import java.util.Date;
import java.util.List;

public interface FerryRequestService {
	public void addAndAudit(FerryRequest obj) throws Exception;
	public void addWithStatus(Object obj, String statusId) throws Exception;
	public void modifyAndAudit(FerryRequest obj) throws Exception;
	public FerryRequest getWithParamValues(String requestId) throws Exception;
	public FerryRequest getWithTask(String requestId) throws Exception;
	
	/**
	 * 2014年6月修订时加入
	 * 查询一个文件资源在最近一次摆渡时的最后修改时间
	 * @param entryId
	 * @return
	 */
	public Long getFileEntryLastModifyTime(String taskId, String entryId);
	
	public Date getLatestRequestExecTime(String requestId) throws Exception;
	public List getNeedCollectingRequests() throws Exception;
	public List getNeedPartitionRequests() throws Exception;
	public List getNeedBurningRequests() throws Exception;
	
	
	public void changeRequestStatus(String requestId, String status) throws Exception;
	public void saveExecTime(String requestId, Date date) throws Exception;
	
	/**
	 * 清理摆渡请求至开始状态，即至刚生成的状态
	 * 1、清理缓存中收集到的数据
	 * 2、清理数据库中记录的目录数据
	 * @param request
	 */
	public void clearRequest(FerryRequest request) throws Exception;
	
	/**
	 * 为支持多线程处理，留下的方法接口
	 * @param request
	 */
	public void startCollect(FerryRequest request) throws Exception;
	public void startCheck(FerryRequest request) throws Exception;
	public void startPartition(FerryRequest request) throws Exception;
	public void startBurn(FerryRequest request) throws Exception;	
	
	
	public void finishTaskOfRequest(FerryRequest request) throws Exception;
}
