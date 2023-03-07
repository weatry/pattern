package com.github.budwing.pattern;

public interface Stack {
	void push(Object obj);

	Object pop();
}

class StackByComposite implements Stack {
	private SimpleList list = new SimpleList();
	
	public void push(Object obj) {
		list.add(list.length, obj);
	}
	
	public Object pop() {
		return list.remove(list.length);
	}
}

class StackByInheritance extends SimpleList implements Stack {
	public void push(Object obj) {
		super.add(super.length, obj);
	}

	public Object pop() {
		return super.remove(super.length);
	}
}
