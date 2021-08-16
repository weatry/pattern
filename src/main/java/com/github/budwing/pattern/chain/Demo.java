package com.github.budwing.pattern.chain;


public class Demo {

	public static void main(String[] args) {

		ExceptionHolder chain = ExceptionHolder.createChain(new SQLExceptionHolder(),
				new IOExceptionHolder(),
				new NullExceptionHolder());
		
		chain.process(new Exception());
	}

}
