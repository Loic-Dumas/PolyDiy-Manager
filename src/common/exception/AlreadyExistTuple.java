package common.exception;

/**
 * Throw this exception if a copy of a tuple is already registered.
 */
public class AlreadyExistTuple extends Exception {
	private static final long serialVersionUID = 1L;

	private String className = "";
	
	/**
	 * Constructor of the exception.
	 * @param className - name of the concerned class (corresponding to the relation).
	 */
	public AlreadyExistTuple(String className) {
		this.className = className;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Tuple of type " + this.className + " already exists.";
	}
}
