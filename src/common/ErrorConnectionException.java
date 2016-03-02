package common;

public class ErrorConnectionException extends Exception {
<<<<<<< HEAD
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error : connection to DataBase impossible.";
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	public String getMessage(){
		return "Error : connection to Date Base impossible.";
>>>>>>> 19d096cf176426501c504bd725533a34c2c0b4e0
	}
}
