package com.github.budwing.pattern.ferry.vo;

import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FerryStatus {
	public static final String NEW = "new";                 //新建，未提交审核
	public static final String SUBMIT = "submit";           //提交审核，未审批
	public static final String PASS = "audit_pass";         //审批通过
	public static final String REFUSE = "audit_refuse";     //审批否决
	public static final String QUEUE = "queue";             //进入队列排队，等待处理
	public static final String GATHER = "gather_data";      //收集数据
	public static final String GATHER_COMPLETE = "gather_complete";        //收集数据完成
	public static final String GATHER_NOTHING = "gather_nothing";          //什么数据也没收集到
	public static final String PARTITION = "partition";					   //正在分块
	public static final String PARTITION_COMPLETE = "partition_complete";  //分块完成
	public static final String WAIT_BURNING = "wait_burning";              //光驱弹出，等待放入空盘
	public static final String BURNING = "burning";                        //正在刻录
	public static final String BURNING_COMPLETE = "burning_complete";      //刻录完成
	public static final String BURNING_ERROR = "burning_error";            //刻录出错
	public static final String WAIT_FERRY = "wait_ferry";                  //光驱弹出，等待取走光盘，进行摆渡
	public static final String FERRYING = "ferrying";                      //光盘被取走，正在摆渡中
	public static final String CACHE_FOR_BURNING = "cache_for_burning";                      //已经分块完成，但未达到刻录数据要求值，等待缓存数据足够后刻录
	public static final String ERROR = "error";                      //已经分块完成，但未达到刻录数据要求值，等待缓存数据足够后刻录
	public static final String SCAN_VIRUS = "scan_virus";
	public static final String SCAN_VIRUS_FAIL = "scan_virus_fail";
	public static final String SCAN_VIRUS_FINISHED = "scan_virus_finished";
	public static final String ENCRYPTING = "encrypting";
	public static final String ENCRYPT_FAIL = "encrypt_fail";
	public static final String ENCRYPT_FINISHED = "encrypt_finished";
	
    private String statusId;
    private String statusName;
    private String statusDesc;
    private Date statusTime;
    
    private static Map<String, SoftReference<FerryStatus>> cache = new HashMap<String, SoftReference<FerryStatus>>();
    
    public static FerryStatus getStatus(String id) {
    	SoftReference<FerryStatus> status = cache.get(id);
    	
    	if(status==null || status.get()==null) {
    		status = new SoftReference<FerryStatus>(new FerryStatus(id));
    		cache.put(id, status);
    	}
    	
    	return status.get();
    }

    private FerryStatus() {
		super();
	}

	private FerryStatus(String statusId) {
		super();
		this.statusId = statusId;
	}

	public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}
}