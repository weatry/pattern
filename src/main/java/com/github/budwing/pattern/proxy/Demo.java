package com.github.budwing.pattern.proxy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo {

	public static void main(String[] args) throws Exception {
		/*List list = new ArrayList();
		InvocationHandler ih = new MyInvocationHandler(list);
		List proxy = (List)Proxy.newProxyInstance(list.getClass().getClassLoader(), 
				new Class[]{List.class}, ih);
		
		proxy.add("sfd");
		
		System.out.println(list.get(0));*/
		
		final FileOutputStream fileOut = new FileOutputStream("f:/1.txt");
		
		new Thread() {

			@Override
			public void run() {
				try {
					OutputStream out1 = new LogOutputStream(fileOut);
					out1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		
		new Thread() {

			@Override
			public void run() {
				try {
					OutputStream out1 = new LogOutputStream(fileOut);
					out1.write("sdfsdfsdf".getBytes());
					out1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}

}
