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
	
	/**
	 * Throw this exception if a negative was taped.
	 * @param priceUnit
	 */
	public InvalidPriceException(float priceUnit){
		this.invalidpriceUnit = priceUnit;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The price : " + invalidpriceUnit + " is invalid. Price should be positive.";
		}
}
