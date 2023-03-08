package com.github.budwing.pattern.proxy.dpnative;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo {

	public static void main(String[] args) throws Exception {
		final FileOutputStream fileOut = new FileOutputStream("f:/proxy.log");
		
		new Thread() {

			@Override
			public void run() {
				try {
					OutputStream out = new LogOutputStream(fileOut);
					out.write("write byte thread 1\n".getBytes());
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		
		new Thread() {

			@Override
			public void run() {
				try {
					OutputStream out = new LogOutputStream(fileOut);
					out.write("write byte thread 2\n".getBytes());
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}
}
