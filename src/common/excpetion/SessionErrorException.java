package common.excpetion;

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
	
	public SessionErrorException(int ID) {
		this.ID = ID;
	}
	
	public String getMessage() {
		return "A session is already opened for the user " + ID + ".";
	}
}
