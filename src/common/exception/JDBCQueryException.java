package common.exception;

public class JDBCQueryException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "The query's syntaxe is incorrect.";
	}
}
