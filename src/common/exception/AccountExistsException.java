package common.exception;

/**
 * Throw this exception when an account with same mail or email is already registered.
 */
public class AccountExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "An account with the same mail or the same login is already registered.";
	}
}
