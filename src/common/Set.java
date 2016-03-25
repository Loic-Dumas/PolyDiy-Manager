package common;

import java.util.ArrayList;

public class Set<T> {
	protected ArrayList<T> set = new ArrayList<T>();

	public void addElement(T element) {
		this.set.add(element);
	}
	
	public T getElementByIndex(int index) {
		return this.set.get(index);
	}
	
	public T removeElementByIndex(int index) {
		return this.set.remove(index);
	}
	
	public int count() {
		return this.set.size();
	}
	
	public boolean contains(T element) {
		return this.set.contains(element);
	}
	 public boolean isEmpty() {
		 return this.set.isEmpty();
	 }
	 
	 public void clear() {
		 this.set.clear();
	 }

}
