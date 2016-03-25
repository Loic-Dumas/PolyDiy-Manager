package common.exception;

public class AccountExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "An account with the same mail or the same login is already registered.";
	}
}
