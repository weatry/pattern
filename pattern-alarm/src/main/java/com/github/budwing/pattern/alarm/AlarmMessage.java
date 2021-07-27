package com.github.budwing.pattern.alarm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class AlarmMessage {
	private String desease;
	private int duration;
	private int patientNumber;
	private String district;
	private Date time;
	private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	
	private AlarmDevice device;

	public String getDesease() {
		return desease;
	}

	public void setDesease(String desease) {
		this.desease = desease;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public SimpleDateFormat getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(SimpleDateFormat timeFormat) {
		this.timeFormat = timeFormat;
	}
	
	public AlarmDevice getDevice() {
		return device;
	}

	public void setDevice(AlarmDevice device) {
		this.device = device;
	}

	public abstract String build();
	
	public boolean sendTo(List<Employee> contacts) {
		return device.sendMessage(build(), contacts);
	}
}