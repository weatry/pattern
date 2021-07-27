package com.github.budwing.pattern.alarm;

import java.util.List;

public class AlarmExecutor {
	SMSAlarmMessage smsMsg = new SMSAlarmMessage();
	EmailAlarmMessage emailMsg = new EmailAlarmMessage();
	PhoneAlarmMessage phoneMsg = new PhoneAlarmMessage();

	public boolean sendMsg(List<Employee> contacts) {
		smsMsg.sendTo(contacts);

		emailMsg.sendTo(contacts);

		phoneMsg.sendTo(contacts);

		return false;
	}


	/*public static void main(String[] args) {
		Alarm a = new Alarm();
		a.setDesease("伤寒");
		a.setDistrict("山东省潍坊市");
		a.setDuration(5);
		a.setPatientNumber(38);
		a.setTime(new Date());

		a.setSmsURL("http://www.sina.com.cn");

		a.sendMsg(new ArrayList());
	}*/
}

