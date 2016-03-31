package common.exception;

public class NoCartException extends Exception {
	private static final long serialVersionUID = 1L;

	private int IDUser ;

	public NoCartException(int IDUser) {
		this.IDUser = IDUser;
	}

	@Override
	public String getMessage() {
		return "The user with id : " + this.IDUser + " doesn't have any Cart. Please first create a wishList named 'Cart'.";
	}

}
