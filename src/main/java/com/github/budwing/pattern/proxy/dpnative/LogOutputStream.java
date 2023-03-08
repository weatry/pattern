package com.github.budwing.pattern.proxy.dpnative;

import java.io.IOException;
import java.io.OutputStream;

public class LogOutputStream extends OutputStream {
	
	private static int count = 0;
	
	private OutputStream target;
	
	public LogOutputStream(OutputStream out) {
		this.target = out;
		synchronized (target) {
			count++;
		}
	}

	public void close() throws IOException {
		synchronized (target) {
			if (count == 0) {
				target.close();
			} else {
				count--;
			}
		}
	}

	public void write(int b) throws IOException {
		target.write(b);
	}

	public void flush() throws IOException {
		target.flush();
	}

	public void write(byte[] b, int off, int len) throws IOException {
		target.write(b, off, len);
	}

	public void write(byte[] b) throws IOException {
		target.write(b);
	}

}
