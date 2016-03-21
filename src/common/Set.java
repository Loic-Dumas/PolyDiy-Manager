package common;

import java.util.ArrayList;

public class Set {
	private ArrayList<Object> set = new ArrayList<Object>();
	
	public void addElement(Object element) {
		this.set.add(element);
	}
	
	public Object getElementByIndex(int index) {
		return this.set.get(index);
	}
	
	public Object removeElementByIndex(int index) {
		return this.set.remove(index);
	}
	
	public int count() {
		return this.set.size();
	}
	
	public boolean contains(Object element) {
		return this.set.contains(element);
	}
	 public boolean isEmpty() {
		 return this.set.isEmpty();
	 }
	 
	 public void clear() {
		 this.set.clear();
	 }

}
