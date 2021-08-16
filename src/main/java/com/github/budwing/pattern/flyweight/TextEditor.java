package com.github.budwing.pattern.flyweight;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class TextEditor {
	private Map<Character,SoftReference<Letter>> cache = new HashMap<Character,SoftReference<Letter>>();
	
	public Letter getLetter(char c) {
		SoftReference<Letter> result = cache.get(c);
		if(result==null || result.get()==null) {
			result = new SoftReference(new Letter(c));
			cache.put(c, (result));
		}
		return result.get();
	}
}
