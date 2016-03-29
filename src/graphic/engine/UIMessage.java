package graphic.engine;

import java.util.HashMap;
import java.util.Map;

public class UIMessage {
	private String transition = "";
	private Map<String, Object> sharedElements = new HashMap<String, Object>();
	
	public String getTransition() {
		return this.transition;
	}
	
	public void setTransition(String transition) {
		this.transition = transition;
	}
	
	void shareElement(String key, Object element) {
		if(this.isExisting(key)) {
			this.sharedElements.replace(key, element);
		} else {
			this.sharedElements.put(key, element);
		}
	}
	
	void removeElement(String key) {
		if(this.isExisting(key)) {
			this.sharedElements.remove(key);
		}
	}
	
	Boolean isExisting(String key) {
		return this.sharedElements.containsKey(key);
	}
	
	Object getElement(String key) {
		return this.sharedElements.get(key);
	}
}
