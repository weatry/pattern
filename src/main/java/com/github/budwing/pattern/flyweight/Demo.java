package com.github.budwing.pattern.flyweight;

public class Demo {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		Letter a = editor.getLetter('a');
		Letter a1 = editor.getLetter('a');
		
		System.out.println(a==a1);
	}

}
