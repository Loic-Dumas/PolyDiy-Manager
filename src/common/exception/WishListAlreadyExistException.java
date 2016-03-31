package common.exception;

/**
 * This exception is thrown when connection to the database is impossible.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class WishListAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private String invalidName;
	
	/**
	 * Constructor for the exception.
	 * @param labelWishList - the label for wishlist which already exists.
	 */
	public WishListAlreadyExistException(String labelWishList){
		this.invalidName = labelWishList;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Impossible to create the wish List with name : " + invalidName;
	}

}