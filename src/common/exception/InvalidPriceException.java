package common.exception;

/**
 * This exception is thrown when the user enter an invalid quantity.
 * Quantity should be positive.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-03
 */
public class InvalidPriceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private float invalidpriceUnit;
	
	public InvalidPriceException(float priceUnit){
		this.invalidpriceUnit = priceUnit;
	}
	
	@Override
	public String getMessage() {
		return "The price : " + invalidpriceUnit + " is invalid. Price should be positive.";
		}
}
