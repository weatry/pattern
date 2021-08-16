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

	public static ExceptionHolder createChain(ExceptionHolder... holders) {
		if (holders==null || holders.length==0) return null;

		ExceptionHolder root = holders[0];
		ExceptionHolder tmp = root;
		for (int i=1; i<holders.length; i++) {
			tmp.setSuccessor(holders[i]);
			tmp = holders[i];
		}

		return root;
	}
}
