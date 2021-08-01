package com.github.budwing.pattern.adapter;

import java.util.List;

public class NewSystem {
	public void process(List list) {
		int len = list.size();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
