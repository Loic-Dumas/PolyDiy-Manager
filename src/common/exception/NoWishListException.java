package common.exception;

/**
 * This exception is throw when no wish list was set.
 */
public class NoWishListException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "No wish list set in this class.";
	}
}
