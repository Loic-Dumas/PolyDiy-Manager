package common.jdbc;

import java.util.List;

public class SQLCondition {
	private String condition = "";
	
	public SQLCondition() {
	}
	
	public SQLCondition(String condition) {
		this.condition += "WHERE " + condition;
	}
	
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
	
	public String get() {
		return this.condition;
	}
}
