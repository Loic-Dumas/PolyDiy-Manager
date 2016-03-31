package common.exception;

/**
 * @author IsilinBN
 * Throw an exception if no profile was choose during creation of account.
 */
public class InvalidTypeAccount extends Exception {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "You have to choose at least one profile";
	}
}
