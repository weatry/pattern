package com.github.budwing.pattern.singleton;

public class Singleton {
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);

		Gender g1 = Gender.getMale();
		Gender g2 = Gender.getMale();
		System.out.println(g1 == g2);
		g1 = Gender.getFemale();
		g2 = Gender.getFemale();
		System.out.println(g1 == g2);

		GenderEnum ge1 = GenderEnum.FEMALE;
		GenderEnum ge2 = GenderEnum.FEMALE;
		System.out.println(ge1 == ge2);
		ge1 = GenderEnum.MALE;
		ge2 = GenderEnum.MALE;
		System.out.println(ge1==ge2);
	}
}
