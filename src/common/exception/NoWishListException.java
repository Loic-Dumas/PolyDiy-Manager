package common.exception;

public class NoWishListException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "No wish list set in this class.";
	}
}
