package com.github.budwing.pattern.alarm;


public class SMSAlarmMessage extends AlarmMessage {
	public String build() {
		StringBuilder smscontent = new StringBuilder("尊敬的领导：\n");
		smscontent.append("截止到").append(getTimeFormat().format(getTime()))
				.append("，在").append(getDistrict()).append(getDuration())
				.append("天内发生了").append(getPatientNumber()).append("起")
				.append(getDesease()).append("感染病例。该数据已超过历史同期水平，请注意防范疫情流行。\n")
				.append("本信息由系统自动生成，不必回复。");
		return smscontent.toString();
	}

}
