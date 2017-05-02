package lecture13;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author vgorin
 *         file created on 5/2/17 1:34 PM
 */


public class CircularList<T> implements Collection<T> {
	private class Node {
		private T value;
		private Node next;

		private Node(T value) {
			this.value = value;
			this.next = this;
		}

		private Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(o == null || getClass() != o.getClass()) {
				return false;
			}

			Node node = (Node) o;

			return value.equals(node.value);
		}

		@Override
		public int hashCode() {
			return value.hashCode();
		}
	}

	private Node current;
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node cur = current.next;
			private int sz = size;
			private int p = 0;

			@Override
			public boolean hasNext() {
				return p < sz;
			}

			@Override
			public T next() {
				if(p++ < sz) {
					T value = cur.value;
					cur = cur.next;
					return value;
				}
				else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				// TODO: implement using locks
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		if(size > 0) {
			Object[] result = new Object[size];
			Node cur = current.next;
			for(int i = 0; i < size; i++) {
				result[i] = cur.value;
				cur = cur.next;
			}
			return result;
		}
		else {
			return new Object[0];
		}
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(T value) {
		if(current == null) {
			current = new Node(value);
		}
		else {
			current = current.next = new Node(value, current.next);
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean result = false;
		for(T e: c) {
			result |= add(e);
		}
		return result;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		current = null;
		size = 0;
	}

	public static void main(String[] args) {
		Collection<Integer> circular = new CircularList<>();
		circular.add(0);
		circular.add(1);
		circular.add(2);
		circular.add(3);
		circular.add(4);
		circular.add(5);
		circular.forEach(System.out::println);
	}
}
