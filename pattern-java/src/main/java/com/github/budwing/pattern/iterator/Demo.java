package com.github.budwing.pattern.iterator;

public class Demo {

	public static void main(String[] args) {
		MyList list = new MyList();
		list.add("sdf");
		list.add(21);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
