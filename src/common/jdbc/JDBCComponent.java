package common.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;

public class JDBCComponent {
	private Statement stmt = null;
	
	public JDBCComponent() throws ErrorConnectionException {
		try {
			this.stmt = JDBConnection.getInstance().getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet select(String selectionIn, String objectIn, String conditionIn) throws JDBCQueryException, ErrorConnectionException {
		if(selectionIn == "" || objectIn == "") {
			throw new JDBCQueryException();
		}
		String query = "SELECT " + selectionIn + " FROM " + objectIn;
		if(conditionIn != "") {
			query += " WHERE " + conditionIn;
		}
		query += ";";
		ResultSet result;
		try {
			result = this.stmt.executeQuery(query);
			if (!result.first()) {
				result = null;
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
		return result;
	}
	
	public void delete(String objectIn, String conditionIn) throws JDBCQueryException, ErrorConnectionException {
		if(objectIn == "" || conditionIn == "") {
			throw new JDBCQueryException();
		}
		String query = "DELETE FROM " + objectIn + " WHERE " + conditionIn + ";";
		try {
			this.stmt.executeQuery(query);
		} catch (SQLException e) {
			if(!e.getMessage().equals("Aucun résultat retourné par la requête.")) {
				throw new ErrorConnectionException();
			}
		}
	}
	
	public void update(String newValueIn, String objectIn, String conditionIn) {
	}
	
	public void insert(String objectIn, String valuesIn) throws ErrorConnectionException, JDBCQueryException {
		if(objectIn == "" || valuesIn == "") {
			throw new JDBCQueryException();
		}
		String query = "INSERT INTO " + objectIn + " VALUES(" + valuesIn + ");";
		try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			if(!e.getMessage().equals("Aucun résultat retourné par la requête.")) {
				throw new ErrorConnectionException();
			}
		}
	}
	
	public void clear() {
		try {
			this.stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
