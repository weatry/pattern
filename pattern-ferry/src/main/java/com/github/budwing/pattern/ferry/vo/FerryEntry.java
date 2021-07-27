package com.github.budwing.pattern.ferry.vo;

import java.util.Date;

public class FerryEntry {
    private String entryId;
    private String typeId;
    private String userId;
    private String entryName;
    private String entryDesc;
    private String entrySrcMachine;
    private String entrySrcObj;
    private String entryTargetMachine;
    private String entryTargetObj;
    private String entryObjType;
    private Date entryCreateTime;
    private Boolean entryValid;
    
    private Integer indexOfTask;

    public FerryEntry() {
		super();
	}

	public FerryEntry(String entryId) {
		super();
		this.entryId = entryId;
	}

	public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryDesc() {
		return entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		this.entryDesc = entryDesc;
	}

	public String getEntrySrcMachine() {
        return entrySrcMachine;
    }

    public void setEntrySrcMachine(String entrySrcMachine) {
        this.entrySrcMachine = entrySrcMachine;
    }

	public String getEntrySrcObj() {
        return entrySrcObj;
    }

    public void setEntrySrcObj(String entrySrcObj) {
        this.entrySrcObj = entrySrcObj;
    }

    public String getEntryTargetMachine() {
        return entryTargetMachine;
    }

    public void setEntryTargetMachine(String entryTargetMachine) {
        this.entryTargetMachine = entryTargetMachine;
    }

    public String getEntryTargetObj() {
        return entryTargetObj;
    }

    public void setEntryTargetObj(String entryTargetObj) {
        this.entryTargetObj = entryTargetObj;
    }

    public String getEntryObjType() {
        return entryObjType;
    }

    public void setEntryObjType(String entryObjType) {
        this.entryObjType = entryObjType;
    }

    public Date getEntryCreateTime() {
        return entryCreateTime;
    }

    public void setEntryCreateTime(Date entryCreateTime) {
        this.entryCreateTime = entryCreateTime;
    }

	public Boolean getEntryValid() {
		return entryValid;
	}

	public void setEntryValid(Boolean entryValid) {
		this.entryValid = entryValid;
	}

	public Integer getIndexOfTask() {
		return indexOfTask;
	}

	public void setIndexOfTask(Integer indexOfTask) {
		this.indexOfTask = indexOfTask;
	}

}