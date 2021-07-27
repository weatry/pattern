package com.github.budwing.pattern.alarm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class SMSAlarmMessage extends AlarmMessage {
	private String smsURL;
	private int smsRetryTimes = 3;

	public String build() {
		StringBuilder smscontent = new StringBuilder("尊敬的领导：\n");
		smscontent.append("截止到").append(getTimeFormat().format(getTime())).append("，在")
				.append(getDistrict()).append(getDuration()).append("天内发生了")
				.append(getPatientNumber()).append("起").append(getDesease())
				.append("感染病例。该数据已超过历史同期水平，请注意防范疫情流行。\n")
				.append("本信息由系统自动生成，不必回复。");
		return smscontent.toString();
	}
	
	public boolean send(List<Employee> contacts) {
		String smscontent = build();
		int index = 0;
		try {
			StringBuilder sb = new StringBuilder(smsURL);
			sb.append("?msg=")
					.append(URLEncoder.encode(smscontent.toString(), "utf-8"))
					.append("&contacts=");
			StringBuilder contactsStr = new StringBuilder();
			
			for (Employee e : contacts) {
				if (e.getMobile() != null && !e.getMobile().isEmpty()) {
					if (index > 0)
						contactsStr.append(",");
					contactsStr.append(e.getMobile());
					index++;
				}
			}
			sb.append(contactsStr);

			String smsResult = null;
			for (int i = 0; i < smsRetryTimes; i++) {
				URL url = new URL(sb.toString());
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				smsResult = reader.readLine();
				if (smsResult.equals("done")) {
					log(contacts, 1, smscontent.toString(), "success");
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(contacts, 1, smscontent.toString(), "failure");
		}
		
		return true;
	}

}
