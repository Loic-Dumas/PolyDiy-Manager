package common.exception;

/**
 * This exception is thrown when the user enter an unkwnown login.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class UnknownLoginException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String unknownLogin;
	
	/**
	 * Constructor of the exception.
	 * @param login - the login which is unknown.
	 */
	public UnknownLoginException(String login){
		this.unknownLogin = login;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "" + unknownLogin + " is unknown.";
	}
}
