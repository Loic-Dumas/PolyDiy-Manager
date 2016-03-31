package common.exception;

import java.util.List;

/**
 * @author IsilinBN
 * Throw this exception if a unique attribute is waited and it was not a unique attribute.
 */
public class NotUniqueAttribute extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String attributes = "";
	private String component = "";
	
	/**
	 * Constructor of the exception.
	 * @param attribute - the wrong attribute
	 * @param component - the concerned component.
	 */
	public NotUniqueAttribute(String attribute, String component) {
		this.attributes = attribute;
		this.component = component;
	}
	
	/**
	 * Constructor of the exception.
	 * @param attributes - the wrong attributes.
	 * @param component - the concerned component.
	 */
	public NotUniqueAttribute(List<String> attributes, String component) {
		for(String element : attributes) {
			this.attributes += element + ",";
		}
		this.attributes = this.attributes.substring(0, this.attributes.length() - 1);
		this.component = component;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The attributes " + this.attributes + " are not unique for " + this.component + ".";
	}
}
