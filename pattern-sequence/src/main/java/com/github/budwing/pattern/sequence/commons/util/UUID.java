package com.github.budwing.pattern.sequence.commons.util;

public class UUID {

	public static UUIDGenerator uuid = new UUIDGenerator();

	public static String getUuid() {
		return uuid.generate().toString();
	}
}
