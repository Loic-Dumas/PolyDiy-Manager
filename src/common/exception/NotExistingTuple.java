package common.exception;

/**
 * This exception is throw when no tuple was found for the given class name.
 */
public class NotExistingTuple extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String className = "";
	
	/**
	 * Constructor of the exception.
	 * @param className - the gien class name.
	 */
	public NotExistingTuple(String className) {
		this.className = className;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The tuple of type " + this.className + " doesn't exist.";
	}
}
