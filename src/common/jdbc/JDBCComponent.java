package common.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;

/**
 * @author IsilinBN
 * A facade to declare quickly SQL queries.
 */
public class JDBCComponent {
	private Statement stmt = null;
	
	public JDBCComponent() throws ErrorConnectionException, AlertDriver {
		try {
			this.stmt = JDBConnection.getInstance().getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/**
 * Out of date version
 * @param selectionIn - the selection element of the query.
 * @param objectIn
 * @param conditionIn
 * @return the result if exist, null else
 */
public ResultSet select(String selectionIn, String objectIn, String conditionIn) {
		String query = "SELECT " + selectionIn + " FROM " + objectIn;
		if(conditionIn != "") {
			query += " WHERE " + conditionIn;
		}
		query += ";";
		Boolean result = false;
		try {
			System.out.println(query);
			result = this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result) {
			try {
				return this.stmt.getResultSet();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * @param selectionIn
	 * @param objectIn
	 * @param conditionIn
	 * @return
	 */
	public ResultSet select(List<String> selectionIn, String objectIn, SQLCondition conditionIn) {
		String query = "SELECT ";
		if(selectionIn.isEmpty()) {
			query += "*";
		} else {
			for(String element : selectionIn) {
				query += element + ",";
			}
			query = query.substring(0, query.length()-1);
		}
		
		query += " FROM " + objectIn;
		query += conditionIn.get();
		query += ";";
		Boolean result = false;
		try {
			System.out.println(query);
			result = this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result) {
			try {
				return this.stmt.getResultSet();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * @param objectIn
	 * @param conditionIn
	 */
	public void delete(String objectIn, SQLCondition conditionIn){
		String query = "DELETE FROM " + objectIn + conditionIn.get() + ";";
		try {
			System.out.println(query);
			this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param newValueIn
	 * @param objectIn
	 * @param conditionIn
	 */
	public void update(String newValueIn, String objectIn, SQLCondition conditionIn) {
		String query = "UPDATE " + objectIn + " SET " + newValueIn + conditionIn.get();
		query += ";";
		try {
			System.out.println(query);
			this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param objectIn
	 * @param valuesIn
	 */
	public void insert(String objectIn, String valuesIn) {
		String query = "INSERT INTO " + objectIn + " VALUES(" + valuesIn + ");";
		try {
			System.out.println(query);
			this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Out of date version
	 * @param objectIn
	 * @param conditionIn
	 */
	public void delete(String objectIn, String conditionIn){
		String query = "DELETE FROM " + objectIn + " WHERE " + conditionIn + ";";
		try {
			System.out.println(query);
			this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Out of date version
	 * @param newValueIn
	 * @param objectIn
	 * @param conditionIn
	 */
	public void update(String newValueIn, String objectIn, String conditionIn) {
		String query = "UPDATE " + objectIn + " SET " + newValueIn;
		if(conditionIn != "") {
			System.out.println(query);
			query += " WHERE " + conditionIn; 
		}
		query += ";";
		try {
			this.stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void clear() {
		try {
			this.stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
