package com.github.budwing.pattern.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EnumList implements List {
	private ArrayList data;
	
	public EnumList(Enumeration e) {
		this.data = new ArrayList();
		while(e.hasMoreElements()) {
			data.add(e.nextElement());
		}
	}

	public void add(int arg0, Object arg1) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public boolean add(Object arg0) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public boolean addAll(Collection arg0) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public boolean addAll(int arg0, Collection arg1) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public void clear() {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public boolean containsAll(Collection arg0) {
		throw new UnsupportedOperationException("此集合类型不支持添加数据！");
	}

	public Object get(int index) {
		return data.get(index);
		
	}

	public int indexOf(Object arg0) {
		return 0;
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public Iterator iterator() {
		return data.iterator();
	}

	public int lastIndexOf(Object arg0) {
		return 0;
	}

	public ListIterator listIterator() {
		return null;
	}

	public ListIterator listIterator(int arg0) {
		return null;
	}

	public Object remove(int arg0) {
		return null;
	}

	public boolean remove(Object arg0) {
		return false;
	}

	public boolean removeAll(Collection arg0) {
		return false;
	}

	public boolean retainAll(Collection arg0) {
		return false;
	}

	public Object set(int arg0, Object arg1) {
		return null;
	}

	public int size() {
		return data.size();
	}

	public List subList(int arg0, int arg1) {
		return null;
	}

	public Object[] toArray() {
		return null;
	}

	public Object[] toArray(Object[] arg0) {
		return null;
	}

}
