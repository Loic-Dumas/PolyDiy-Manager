package common.exception;

public class NotUniqueAttribute extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String attribute = "";
	private String component = "";
	
	public NotUniqueAttribute(String attribute, String component) {
		this.attribute = attribute;
		this.component = component;
	}
	
	public String getMessage() {
		return "The attribute " + this.attribute + " is not unique for " + this.component + ".";
	}
}
