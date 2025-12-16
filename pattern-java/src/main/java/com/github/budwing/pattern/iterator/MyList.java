package com.github.budwing.pattern.iterator;

public class MyList {
	private Object[] datas = new Object[100];
	private int length = 0;

	private class MyIterator implements Iterator {
		private Object[] datas;
		private int length;
		private int pos;

		public MyIterator(Object[] datas, int length) {
			super();
			this.datas = datas;
			this.length = length;
		}

		public boolean hasNext() {
			return pos < length;
		}

		public Object next() {
			Object obj = null;
			if(pos<length) {
				obj = datas[pos];
				pos++;
			}
			return obj;
		}

	}

	public void add(Object obj) {
		datas[length] = obj;
		length++;
	}

	public Iterator iterator() {
		return new MyIterator(this.datas, this.length);
	}
}
