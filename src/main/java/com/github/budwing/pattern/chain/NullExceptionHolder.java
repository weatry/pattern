package com.github.budwing.pattern.chain;

import java.sql.SQLException;

public class NullExceptionHolder extends ExceptionHolder {

	@Override
	public void process(Exception e) {
		// TODO Auto-generated method stub
		if(e instanceof NullPointerException) {
			System.out.println("Null Exception occur!");
			return;
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
