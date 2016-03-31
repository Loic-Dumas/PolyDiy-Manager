package common.exception;

/**
 * This error is thrown when no element from a LoadFromStringKey(name, value) are returned
 * 
 * @author loicd_000
 *
 */
/**
 * Throw the exception if a parameter is unknow in a load request.
 */
public class LoadFromStringKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	private String unknownValue;
	private String unknownName;
	private String unknownTable;
	
	/**
	 * Constructor of the exception.
	 * @param table - the concerned table.
	 * @param name - name of the unknown column.
	 * @param value - value use during wrong load.
	 */
	public LoadFromStringKeyException(String table, String name, String value){
		this.unknownValue = value;
		this.unknownName = name;
		this.unknownTable = table;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "" + unknownTable + " has no element : " + unknownName + " with value : " + unknownValue + " is unknown.";
	}
}