package common;

public class PasswordErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "The password is incorrect.";
	}

}
