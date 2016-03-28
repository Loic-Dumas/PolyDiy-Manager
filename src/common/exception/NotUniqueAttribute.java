package common.exception;

import java.util.List;

public class NotUniqueAttribute extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String attributes = "";
	private String component = "";
	
	public NotUniqueAttribute(List<String> attributes, String component) {
		for(String element : attributes) {
			this.attributes += element + ",";
		}
		this.attributes = this.attributes.substring(0, this.attributes.length() - 1);
		this.component = component;
	}
	
	public String getMessage() {
		return "The attributes " + this.attributes + " are not unique for " + this.component + ".";
	}
}
