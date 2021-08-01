package com.github.budwing.pattern.visitor;

public class TriTreeInOldStyle {
	NodeInOldStyle root;
	
	public void add(int quantity) {
		add(root, quantity);
	}
	
	public void sub(int quantity) {
		
	}
	
	private void add(NodeInOldStyle node, int quantity) {
		node.value = node.value+quantity;
		if(node.left!=null) {
			add(node.left, quantity);
		}
		if(node.middle!=null) {
			add(node.middle, quantity);
		}
		if(node.right!=null) {
			add(node.right, quantity);
		}
	}
}
