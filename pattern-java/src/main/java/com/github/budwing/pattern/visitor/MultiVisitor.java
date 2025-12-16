package com.github.budwing.pattern.visitor;

public class MultiVisitor extends Visitor {

	public void visitNode(Node node) {
		node.value = node.value*2;
	}

}
