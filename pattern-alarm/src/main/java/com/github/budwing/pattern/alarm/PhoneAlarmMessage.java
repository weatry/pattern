package com.github.budwing.pattern.alarm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneAlarmMessage extends AlarmMessage {
	private Map<String, String> voiceMapping = new HashMap();
	private int phoneRetryTimes = 3;
	
	public String build() {
		StringBuilder phonecontent = new StringBuilder("尊敬的领导");
		phonecontent.append("  截止到").append(getTimeFormat().format(getTime()))
				.append(" 在").append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例   该数据已超过历史同期水平  请注意防范疫情流行  ");
		return phonecontent.toString();
	}
	
	public boolean send(List<Employee> contacts) {
		// 打电话
		String phonecontent = build();

		String[] voiceFiles = new String[phonecontent.length()];
		for (int i = 0; i < phonecontent.length(); i++) {
			voiceFiles[i] = voiceMapping.get(phonecontent.charAt(i));
		}

		for (Employee e : contacts) {
			for (int i = 0; i < phoneRetryTimes; i++) {
				if (phone(e.getTelephone(), voiceFiles)) {
					log(e, 3, phonecontent.toString(), "success");
					break;
				}
			}
			log(e, 3, phonecontent.toString(), "failure");
		}
		
		return true;
	}
	
	public native boolean phone(String phoneNum, String[] voiceFiles);
}
