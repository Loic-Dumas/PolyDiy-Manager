package common.excpetion;

/**
 * This exception is thrown when the user enter an invalid password.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class ErrorPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error : Wrong password.";
	}

}
