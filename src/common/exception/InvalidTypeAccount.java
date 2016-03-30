package common.exception;

public class InvalidTypeAccount extends Exception {
	public String getMessage() {
		return "You have to choose at least one profile";
	}
}
