package com.github.budwing.pattern.alarm;

import java.util.List;

public abstract class AlarmDevice {
	public void log(Employee emp, int code, String msg, String state) {

	}

	public void log(List<Employee> emps, int code, String msg, String state) {
		for (Employee e : emps) {
			log(e, code, msg, state);
		}
	}
	
	public abstract boolean sendMessage(String msg, List<Employee> contacts);
}
