package common.exception;

/**
 * This exception is thrown when the user enter an unkwhon password.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class UnknownLoginException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknownLogin;
	
	public UnknownLoginException(String login){
		this.unknownLogin = login;
	}
	
	@Override
	public String getMessage() {
		return "" + unknownLogin + " is unknown.";
	}
}
