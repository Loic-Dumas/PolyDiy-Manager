package common;

public class SessionErrorException extends Exception {
	private static final long serialVersionUID = 1L;
	private int ID;
	
	public SessionErrorException(int ID) {
		this.ID = ID;
	}
	
	public String getMessage() {
		return "A session is already opened for the user " + ID + ".";
	}
}
