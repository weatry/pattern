package com.github.budwing.pattern.singleton;

public class Gender {
	private int code;
	private static Gender male;
	private static Gender female;
	
	private Gender() {
		
	}
	
	public static Gender getMale() {
		if(male==null) {
			male = new Gender();
			male.code = 1;
		}
		return male;
	}
	
	public static Gender getFemale() {
		if(female==null) {
			female = new Gender();
			female.code = 0;
		}
		return female;
	}
	
}
