package com.github.budwing.pattern.visitor;

public class AddVisitor extends Visitor {

	public void visitNode(Node node) {
		node.value=node.value+1;
	}

}
