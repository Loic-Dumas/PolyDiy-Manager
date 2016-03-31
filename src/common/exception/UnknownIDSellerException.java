package common.exception;
/**
 * This exception is thrown when the user enter an unknown ID.
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

public class UnknownIDSellerException extends Exception{
	private static final long serialVersionUID = 1L;
	private int unknownID;
	
	/**
	 * Constructor of the exception.
	 * @param ID - the seller's id which is unknown.
	 */
	public UnknownIDSellerException(int ID){
		this.unknownID = ID;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The seller with ID : " + unknownID + " is unknown.";
		}

}
