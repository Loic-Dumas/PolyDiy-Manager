package common.exception;

/**
 * This exception is thrown when the user is already connected.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class SessionErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	private int ID;
	
	/**
	 * Constructor of the exception
	 * @param ID - the id of the concerned account.
	 */
	public SessionErrorException(int ID) {
		this.ID = ID;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "A session is already opened for the user " + ID + ".";
	}
}
