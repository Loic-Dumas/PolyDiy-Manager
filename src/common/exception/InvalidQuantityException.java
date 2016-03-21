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
	
	public InvalidQuantityException(int quantity){
		this.invalidQuantity = quantity;
	}
	
	@Override
	public String getMessage() {
		return "The quantity is invalid : " + invalidQuantity + " should be positive or not null.";
		}
}
