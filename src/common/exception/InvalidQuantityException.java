package common.exception;

/**
 * This exception is thrown when the user enter an invalid quantity.
 * Quantity should be positive.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-03
 */
public class InvalidQuantityException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private int invalidQuantity;
	
	/**
	 * Constructor of the exception<
	 * @param quantity - quantity which is false.
	 */
	public InvalidQuantityException(int quantity){
		this.invalidQuantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The quantity is invalid : " + invalidQuantity + " should be positive or not null.";
	}
}
