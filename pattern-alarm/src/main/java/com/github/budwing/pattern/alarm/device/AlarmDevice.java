package com.github.budwing.pattern.alarm.device;

import com.github.budwing.pattern.alarm.Employee;

import java.util.List;

public abstract class AlarmDevice {
	public abstract boolean sendMessage(String msg, List<Employee> contacts);
}
