package common.exception;

/**
 * This exception is thrown when the user enter an unknown ID.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-03
 */
public class UnknownIDProductException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int unknownID;
	
	/**
	 * Constructor of the exception.
	 * @param ID - the id which is unknown.
	 */
	public UnknownIDProductException(int ID){
		this.unknownID = ID;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The product with ID : " + unknownID + " is unknown.";
		}
}
