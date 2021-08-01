package com.github.budwing.pattern.chain;

public abstract class ExceptionHolder {
	private ExceptionHolder successor;

	public ExceptionHolder getSuccessor() {
		return successor;
	}

	public void setSuccessor(ExceptionHolder successor) {
		this.successor = successor;
	}
	
	public abstract void process(Exception e);
}
