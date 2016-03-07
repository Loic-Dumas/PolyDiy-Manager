package common.exception;

/**
 * This exception is thrown when connection to the database is impossible.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class ErrorConnectionException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error : connection to DataBase impossible.";
	}
}
