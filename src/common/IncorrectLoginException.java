package common;

public class IncorrectLoginException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "You use incorrect characters in this login.";
	}
}
