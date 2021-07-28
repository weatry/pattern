package com.github.budwing.pattern.ferry.vo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class FerryRequest extends Observable {
    private String requestId;
    private String taskId;
    private String userId;
    private Integer priorityId;
    private String requestBurningType;
    private Integer partitionCount;
    private Integer requestTimes;
    private String ferryRequestDesc;
    private Date requestCreateTime;
    private Date requestExecuteTime;
    private Date requestCompleteTime;

    private List<FerryEntry> entrys;
    private ArrayList<File> burningFiles;
    private FerryStatus status;

    public FerryRequest(String requestId, String taskId, String userId,
			Integer priorityId, String requestBurningType,
			Integer partitionCount, Integer requestTimes,
			String ferryRequestDesc, Date requestCreateTime,
			Date requestExecuteTime, Date requestCompleteTime,
			List<FerryEntry> entrys) {
		super();
		this.requestId = requestId;
		this.taskId = taskId;
		this.userId = userId;
		this.priorityId = priorityId;
		this.requestBurningType = requestBurningType;
		this.partitionCount = partitionCount;
		this.requestTimes = requestTimes;
		this.ferryRequestDesc = ferryRequestDesc;
		this.requestCreateTime = requestCreateTime;
		this.requestExecuteTime = requestExecuteTime;
		this.requestCompleteTime = requestCompleteTime;
		this.entrys = entrys;
	}

	public FerryRequest() {
		super();
	}

	public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getRequestBurningType() {
		return requestBurningType;
	}

	public void setRequestBurningType(String requestBurningType) {
		this.requestBurningType = requestBurningType;
	}

	public Integer getPartitionCount() {
		return partitionCount;
	}

	public void setPartitionCount(Integer partitionCount) {
		this.partitionCount = partitionCount;
	}

	public Integer getRequestTimes() {
        return requestTimes;
    }

    public void setRequestTimes(Integer requestTimes) {
        this.requestTimes = requestTimes;
    }

    public String getFerryRequestDesc() {
        return ferryRequestDesc;
    }

    public void setFerryRequestDesc(String ferryRequestDesc) {
        this.ferryRequestDesc = ferryRequestDesc;
    }

    public Date getRequestCreateTime() {
        return requestCreateTime;
    }

    public void setRequestCreateTime(Date requestCreateTime) {
        this.requestCreateTime = requestCreateTime;
    }

    public Date getRequestExecuteTime() {
        return requestExecuteTime;
    }

    public void setRequestExecuteTime(Date requestExecuteTime) {
        this.requestExecuteTime = requestExecuteTime;
        this.setChanged();
    }

    public Date getRequestCompleteTime() {
        return requestCompleteTime;
    }

    public void setRequestCompleteTime(Date requestCompleteTime) {
        this.requestCompleteTime = requestCompleteTime;
    }

	public List<FerryEntry> getEntrys() {
		return entrys;
	}

	public void setEntrys(List<FerryEntry> entrys) {
		this.entrys = entrys;
	}

	public List<File> getBurningFiles() {
		if (burningFiles != null) {
			return (List<File>) burningFiles.clone();
		}
		
		return null;
	}

	public void setBurningFiles(ArrayList<File> burningFiles) {
		this.burningFiles = burningFiles;
	}

	public FerryStatus getStatus() {
		return status;
	}

	public void setStatus(FerryStatus status) {
		this.status = status;
		this.setChanged();
	}
}