package common;

public class UnknownLoginException extends Exception {
	private static final long serialVersionUID = 1L;
	private String unknownLogin;
	
	public UnknownLoginException(String login) {
		this.unknownLogin = login;
	}
	
	@Override
	public String getMessage() {
		return this.unknownLogin + " is not a registered login.";
	}
}
