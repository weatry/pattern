package com.github.budwing.pattern.chain;

import java.sql.SQLException;

public class SQLExceptionHolder extends ExceptionHolder {

	public void process(Exception e) {
		if(e instanceof SQLException) {
			System.out.println("SQL Exception occur!");
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
