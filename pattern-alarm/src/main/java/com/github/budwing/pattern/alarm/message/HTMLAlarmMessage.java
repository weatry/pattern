package com.github.budwing.pattern.alarm.message;

public class HTMLAlarmMessage extends AlarmMessage {
	public String build() {
		StringBuilder emailContent = new StringBuilder("尊敬的领导：<br/><br/>");
		emailContent.append("&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>")
				.append("截止到").append(getTimeFormat().format(getTime())).append("，<b>在")
				.append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例</b>。该数据已超过历史同期水平，请注意防范疫情流行。<br/>")
				.append("</font><br/><br/><br/>本邮件由系统自动生成，不必回复。");
		return emailContent.toString();
	}
}


