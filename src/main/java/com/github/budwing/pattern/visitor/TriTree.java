package com.github.budwing.pattern.visitor;

public class TriTree {
	Node root;
	public TriTree(Node root) {
		this.root = root;
	}
	
	public void accept(Visitor visitor) {
		accept(root, visitor);
		
	}
	
	private void accept(Node node, Visitor visitor) {
		
		if(node.left!=null) {
			accept(node.left, visitor);
		}
		if(node.middle!=null) {
			accept(node.middle, visitor);
		}
		if(node.right!=null) {
			accept(node.right, visitor);
		}
		visitor.visitNode(node);
	}
}
