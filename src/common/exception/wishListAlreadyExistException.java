package common.exception;

/**
 * This exception is thrown when connection to the database is impossible.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class wishListAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private String invalidName;
	
	public wishListAlreadyExistException(String labelWishList){
		this.invalidName = labelWishList;
	}
	

	@Override
	public String getMessage() {
		return "Impossible to create the wish List with name : " + invalidName;
	}

}