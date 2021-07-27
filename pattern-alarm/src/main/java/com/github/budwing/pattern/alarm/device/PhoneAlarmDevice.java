package com.github.budwing.pattern.alarm.device;

import com.github.budwing.pattern.alarm.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneAlarmDevice extends AlarmDevice {
	private Map<String, String> voiceMapping = new HashMap();

	public boolean sendMessage(String msg, List<Employee> contacts) {
		String[] voiceFiles = new String[msg.length()];
		for (int i = 0; i < msg.length(); i++) {
			voiceFiles[i] = voiceMapping.get(msg.charAt(i));
		}

		for (Employee e : contacts) {
			if (phone(e.getTelephone(), voiceFiles)) {
				break;
			}

		}

		return true;
	}

	public native boolean phone(String phoneNum, String[] voiceFiles);

}
