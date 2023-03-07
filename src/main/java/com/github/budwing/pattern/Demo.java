package com.github.budwing.pattern;

public class Demo {

	public static void main(String[] args) {
		StackByComposite s1 = new StackByComposite();
		s1.push("StackByComposite something1");
		System.out.println(s1.pop());
		// this method is not accessible
		//s1.add(0, "dfd");

		StackByInheritance s2 = new StackByInheritance();
		s2.push("StackByInheritance something2");
		System.out.println(s2.pop());
		// the following methods are still accessible
		s2.add(0, "StackByInheritance something2");
		System.out.println(s2.remove(0));

		// interface can solve a few
		Stack s3 = new StackByInheritance();
		s3.push("Stack something3");
		System.out.println(s3.pop());
		// the following methods are not accessible
		// s3.add(0, "something3");
	}

}
