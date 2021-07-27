package com.github.budwing.pattern.alarm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmMessage {
	private String desease;
	private int duration;
	private int patientNumber;
	private String district;
	private Date time;
	private SimpleDateFormat timeFormat;

	public AlarmMessage(SimpleDateFormat timeFormat) {
		this.timeFormat = timeFormat;
	}

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

	public String buildPhoneMessage() {
		StringBuilder phonecontent = new StringBuilder("尊敬的领导");
		phonecontent.append("  截止到").append(getTimeFormat().format(getTime()))
				.append(" 在").append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例   该数据已超过历史同期水平  请注意防范疫情流行  ");
		return phonecontent.toString();
	}

	public String buildEmailMessage() {
		StringBuilder emailContent = new StringBuilder("尊敬的领导：<br/><br/>");
		emailContent.append("&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>")
				.append("截止到").append(getTimeFormat().format(getTime())).append("，<b>在")
				.append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例</b>。该数据已超过历史同期水平，请注意防范疫情流行。<br/>")
				.append("</font><br/><br/><br/>本邮件由系统自动生成，不必回复。");
		return emailContent.toString();
	}

	public String buildSMSMessage() {
		StringBuilder smscontent = new StringBuilder("尊敬的领导：\n");
		smscontent.append("截止到").append(getTimeFormat().format(getTime())).append("，在")
				.append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例。该数据已超过历史同期水平，请注意防范疫情流行。\n")
				.append("本信息由系统自动生成，不必回复。");
		return smscontent.toString();
	}
}