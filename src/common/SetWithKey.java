package common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SetWithKey<T> {
	protected Map<String, T> setWithKey = new HashMap<String, T>();
	
	/**
	 * @return true if the set is empty
	 */
	public boolean isEmpty() {
		return this.setWithKey.isEmpty();
	}
	
	/**
	 * Add the element with the key.
	 * @param key - String
	 * @param element - T
	 */
	public void addElement(String key, T element) {
		this.setWithKey.put(key, element);
	}
	
	
	/**
	 * Return the value to which the specified key is mapped, or null if this map contains no mapping for the key
	 * @param key - the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
	 */
	public T getElementByKey(String key) {
		return this.setWithKey.get(key);
	}
	
	
	/**
	 * Remove the <key,element> who have the key in this map.
	 * @param key - key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 */
	public T removeElementByKey(String key) {
		return this.setWithKey.remove(key);
	}
	
	
	/**
	 * @return the number of key-value mappings in this map
	 */
	public int count() {
		return this.setWithKey.size();
	}
	
	
	/**
	 * Return true if this map contains a mapping for the specified key
	 * @param key - key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key
	 */
	public boolean containsKey(String key) {
		return this.setWithKey.containsKey(key);
	}
	
	
	/**
	 * Return true if this map maps one or more keys to the specified value
	 * @param element - value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	public boolean containsElement(T element) {
		return this.setWithKey.containsValue(element);
	}
	 
	
	 /**
	 * Removes all of the mappings from this map (optional operation). The map will be empty after this call returns.
	 */
	public void clear() {
		 this.setWithKey.clear();
	 }
	
	
	/**
	 * @return a set view of the keys contained in this map
	 */
	public java.util.Set<String> getAllKeys() {
		return this.setWithKey.keySet();
	}
	
	
	/**
	 * @return a collection view of the values contained in this map
	 */
	public Collection<T> getAllElements() {
		return this.setWithKey.values();
	}
	
}
