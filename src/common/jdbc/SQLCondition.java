package common.jdbc;

import java.util.List;

/**
 * @author IsilinBN
 * Implements a class to declare condition of the WHERE SQL contract.
 */
public class SQLCondition {
	private String condition = "";
	
	/**
	 * Empty constructor.
	 */
	public SQLCondition() {
	}
	
	/**
	 * Constructor with string condition
	 * @param condition
	 */
	public SQLCondition(String condition) {
		this.condition += "WHERE " + condition;
	}
	
	/**
	 * Constructor with some conditions
	 * @param columnNames - left operand of each condition
	 * @param columnValues - right operand of each condition
	 * @throws Exception - if invalid parameters : not the same number of right and left operand.
	 */
	public SQLCondition(List<String> columnNames, List<String> columnValues) throws Exception {
		if(columnNames.size() != columnNames.size()) {
			throw new Exception("Parameter errors !");
		} else {
			if(!columnNames.isEmpty()) {
				this.condition += " WHERE ";
				for(int i = 0 ; i < columnNames.size() ; i++) {
					this.condition += columnNames.get(i) + "=";
					if(!columnValues.get(i).contains(".") && !columnValues.get(i).matches("-?\\d+(\\.\\d+)?")) {
						this.condition += "'";
					}
					this.condition += columnValues.get(i);
					if(!columnValues.get(i).contains(".") && !columnValues.get(i).matches("-?\\d+(\\.\\d+)?")) {
						this.condition += "'";
					}
					if(i < columnNames.size() - 1) {
						this.condition += " AND ";
					}
				}
			}
		}
	}
	
	/**
	 * An accessor to the condition.
	 * @return the condition parsed
	 */
	public String get() {
		return this.condition;
	}
}
