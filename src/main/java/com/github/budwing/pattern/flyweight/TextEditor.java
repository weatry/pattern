package com.github.budwing.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TextEditor {
	private Map<Character,Letter> cache = new HashMap<Character,Letter>();
	
	public Letter getLetter(char c) {
		Letter result = cache.get(c);
		if(result==null) {
			result = new Letter(c);
			cache.put(c, result);
		}
		return result;
	}
}
