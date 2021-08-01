package com.github.budwing.pattern.visitor;

public class Demo {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.middle = new Node(3);
		root.right = new Node(4);
		
		TriTree tree = new TriTree(root);
		
		Visitor print = new PrintVisitor();
		tree.accept(print);
		Visitor add = new AddVisitor();
		tree.accept(add);
		tree.accept(print);
		Visitor m = new MultiVisitor();
		tree.accept(m);
		tree.accept(print);
	}

}
