package common;

public class UnknowLoginException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknowLogin;
	
	public UnknowLoginException(String login){
		this.unknowLogin = login;
	}
	
	@Override
	public String getMessage() {
		return "" + unknowLogin + " is unknown.";
	}
}
