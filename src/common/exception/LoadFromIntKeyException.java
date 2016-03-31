package common.exception;

/**
 * This error is thrown when no element from a LoadFromStringKey(name, value) are returned
 * @author loicd_000
 */
public class LoadFromIntKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	private int unknownValue;
	private String unknownName;
	private String unknownTable;
	
	/**
	 * Constructor of the exception.
	 * @param table - table concerned.
	 * @param name - column concerned.
	 * @param value - value use during the error.
	 */
	public LoadFromIntKeyException(String table, String name, int value){
		this.unknownValue = value;
		this.unknownName = name;
		this.unknownTable = table;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "" + unknownTable + " has no  element : " + unknownName + " with value : " + unknownValue + " is unknown.";
	}
}