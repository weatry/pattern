package com.github.budwing.pattern.chain;


public class Demo {

	public static void main(String[] args) {
		ExceptionHolder sql = new SQLExceptionHolder();
		ExceptionHolder io = new IOExceptionHolder();
		sql.setSuccessor(io);
		io.setSuccessor(new NullExceptionHolder());
		
		ExceptionHolder chain = sql;
		
		chain.process(new Exception());
	}

}
