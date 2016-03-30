package common.exception;

public class InvalidTypeAccount extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "You have to choose at least one profile";
	}
}
