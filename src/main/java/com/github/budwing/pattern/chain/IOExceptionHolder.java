package com.github.budwing.pattern.chain;

import java.io.IOException;

public class IOExceptionHolder extends ExceptionHolder {

	public void process(Exception e) {
		if(e instanceof IOException) {
			System.out.println("IO Exception occur!");
			return;
		} else {
			ExceptionHolder holder = getSuccessor();
			if(holder!=null) {
				holder.process(e);
			} else {
				System.out.println("Can't process exception "+e.getClass());
				return;
			}
		}
	}

}
