package com.github.budwing.pattern.visitor;

public class PrintVisitor extends Visitor {

	public void visitNode(Node node) {
		System.out.println(node.value);
	}

}
