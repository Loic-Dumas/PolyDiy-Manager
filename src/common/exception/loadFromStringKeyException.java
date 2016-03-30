package common.exception;

/**
 * This error is thrown when no element from a LoadFromStringKey(name, value) are returned
 * 
 * @author loicd_000
 *
 */
public class loadFromStringKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	private String unknownValue;
	private String unknownName;
	private String unknownTable;
	
	public loadFromStringKeyException(String table, String name, String value){
		this.unknownValue = value;
		this.unknownName = name;
		this.unknownTable = table;
	}
	
	@Override
	public String getMessage() {
		return "" + unknownTable + " has no element : " + unknownName + " with value : " + unknownValue + " is unknown.";
	}
}