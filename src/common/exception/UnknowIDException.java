package common.exception;

/**
 * This exception is thrown when BD doesn't find the ID.
 * 
 * @author Faustine GEOFFRAY
 * @version 1.0
 * @since 2016-22-03
 */
public class UnknowIDException extends Exception {


	private static final long serialVersionUID = 1L;
	private int unknownID;
	
	/**
	 * Constructor of the exception.
	 * @param login - the unknown id of account.
	 */
	public UnknowIDException(int login){
		this.unknownID = login;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "" + unknownID + " is unknown.";
	}
}
