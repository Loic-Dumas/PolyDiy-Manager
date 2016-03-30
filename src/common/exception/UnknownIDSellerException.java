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
	
	public UnknownIDSellerException(int ID){
		this.unknownID = ID;
	}
	@Override
	public String getMessage() {
		return "The seller with ID : " + unknownID + " is unknown.";
		}

}
