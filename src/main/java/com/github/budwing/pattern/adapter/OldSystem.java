package com.github.budwing.pattern.adapter;

import java.util.Enumeration;
import java.util.Vector;

public class OldSystem {
	public Enumeration data() {
		Vector v = new Vector();
		v.add("1");
		v.add(2);
		v.add(3);
		v.add(4);
		
		return v.elements();
	}
}
