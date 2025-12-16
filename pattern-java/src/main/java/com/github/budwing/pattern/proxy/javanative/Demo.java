package com.github.budwing.pattern.proxy.javanative;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws Exception {
		List list = new ArrayList();
		InvocationHandler ih = new MyInvocationHandler(list);
		List proxy = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(),
				new Class[]{List.class}, ih);

		proxy.add("sfd");

		System.out.println(list.get(0));
	}
}
