package common.exception;

public class AlreadyExistTuple extends Exception {
	private static final long serialVersionUID = 1L;

	private String className = "";
	
	public AlreadyExistTuple(String className) {
		this.className = className;
	}
	
	@Override
	public String getMessage() {
		return "Tuple of type " + this.className + " already exists.";
	}
}
