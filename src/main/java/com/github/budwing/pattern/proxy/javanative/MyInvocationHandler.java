package com.github.budwing.pattern.proxy.javanative;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public MyInvocationHandler(Object obj) {
		this.target = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(target.getClass()+"'s "+method.getName()+" is invoking!");
		return method.invoke(target, args);
	}

	

}
