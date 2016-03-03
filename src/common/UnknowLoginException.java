package common;

/**
 * This exception is thrown when the user enter an unkwhon password.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class UnknowLoginException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknowLogin;
	
	public UnknowLoginException(String login){
		this.unknowLogin = login;
	}
	
	@Override
	public String getMessage() {
		return "" + unknowLogin + " is unknown.";
	}
}
