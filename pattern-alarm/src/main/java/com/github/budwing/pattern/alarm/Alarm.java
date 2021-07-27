package com.github.budwing.pattern.alarm;

import com.github.budwing.pattern.alarm.device.AlarmDevice;
import com.github.budwing.pattern.alarm.message.AlarmMessage;

import java.util.List;

public class Alarm {
	private AlarmMessage message;
	private AlarmDevice device;
	private List<Employee> contacts;
	private int retryTimes;
	
	public Alarm(AlarmMessage message, AlarmDevice device,
			List<Employee> contacts, int retryTimes) {
		super();
		this.message = message;
		this.device = device;
		this.contacts = contacts;
		this.retryTimes = retryTimes;
	}
	
	public int getRetryTimes() {
		return retryTimes;
	}

	public void log(Employee emp, int code, String msg, String state) {

	}

	public void log(List<Employee> emps, int code, String msg, String state) {
		for (Employee e : emps) {
			log(e, code, msg, state);
		}
	}
	
	public boolean execute() {
		message.setDevice(device);
		boolean result = message.sendTo(contacts);
		
		log(contacts, 1, message.build(), String.valueOf(result));
		
		return result;
	}
}
