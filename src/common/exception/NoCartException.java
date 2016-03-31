package common.exception;

/**
 * @author IsilinBN
 * Throw this exception when a cart is waited for a user who doesn't got cart.
 */
public class NoCartException extends Exception {
	private static final long serialVersionUID = 1L;

	private int IDUser ;

	/**
	 * Constructor for the exception.
	 * @param IDUser - the id of the concerned user.
	 */
	public NoCartException(int IDUser) {
		this.IDUser = IDUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The user with id : " + this.IDUser + " doesn't have any Cart. Please first create a wishList named 'Cart'.";
	}

}
