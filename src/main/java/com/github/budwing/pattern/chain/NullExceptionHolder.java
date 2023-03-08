package com.github.budwing.pattern.chain;

public class NullExceptionHolder extends ExceptionHolder {

	@Override
	public void process(Exception e) {
		if(e instanceof NullPointerException) {
			System.out.println("Null Exception occur!");
		} else {
			ExceptionHolder holder = getSuccessor();
			if(holder!=null) {
				holder.process(e);
			} else {
				System.out.println("Can't process exception "+e.getClass());
			}
		}
	}

}
