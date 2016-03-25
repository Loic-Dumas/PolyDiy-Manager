package common.exception;

public class AlertDriver extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "PostgreSQL driver cannot be found.";
	}
}
