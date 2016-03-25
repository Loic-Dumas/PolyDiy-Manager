package common.exception;

public class NotExistingTuple extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String className = "";
	
	public NotExistingTuple(String className) {
		this.className = className;
	}
	
	@Override
	public String getMessage() {
		return "The tuple of type " + this.className + " doesn't exist.";
	}
}
