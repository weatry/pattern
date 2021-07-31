package cn.budwing.stock.util;

public class UUID {
	public static String generateRandomUUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}
}
