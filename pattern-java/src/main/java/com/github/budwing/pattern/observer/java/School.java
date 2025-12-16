package com.github.budwing.pattern.observer.java;

import java.util.Observable;

/**
 * Observable has been deprecated since Java 9.
 * 1. Observable should be an interface.
 * 2. setChanged is quite strange, it's quite common that the programmer forget to invoke it.
 * 3. it's not thread safe.
 * 4. it's too simple, does not support event or message filter
 */
public class School extends Observable {

	public synchronized void setChanged() {
		super.setChanged();
	}
	
	
}
