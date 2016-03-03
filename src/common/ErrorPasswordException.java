package common;

public class ErrorPasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error : Wrong password.";
	}

}
