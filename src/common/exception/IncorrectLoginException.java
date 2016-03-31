package common.exception;

/**
 * This exception is thrown when the user try to connect him with a password with an incorrect password.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class IncorrectLoginException extends Exception {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "You use incorrect characters in this login.";
	}
}
