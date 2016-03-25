package common.exception;

public class JDBCQueryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String query = "";

	public JDBCQueryException(String query) {
		this.query = query;
	}
	
	public String getMessage() {
		return "The query's syntaxe is incorrect : \"" + this.query + "\".";
	}
}
