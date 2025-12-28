package com.github.budwing.pattern.iterator;

public class MyList {
	private Object[] data = new Object[100];
	private int length = 0;

	private class MyIterator implements Iterator {
		private Object[] data;
		private int length;
		private int pos;

		public MyIterator(Object[] data, int length) {
			super();
			this.data = data;
			this.length = length;
		}

		public boolean hasNext() {
			return pos < length;
		}

		public Object next() {
			Object obj = null;
			if (pos < length) {
				obj = data[pos];
				pos++;
			}
			return obj;
		}

	}

	public void add(Object obj) {
		data[length] = obj;
		length++;
	}

	public Iterator iterator() {
		return new MyIterator(this.data, this.length);
	}
}
