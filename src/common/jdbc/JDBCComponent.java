package common.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;

public class JDBCComponent {
	public ResultSet select(String selectionIn, String objectIn, String conditionIn) throws JDBCQueryException, ErrorConnectionException {
		if(selectionIn == "" || objectIn == "") {
			throw new JDBCQueryException();
		}
		String query = "SELECT " + selectionIn + " FROM " + objectIn;
		if(conditionIn != "") {
			query += " WHERE " + conditionIn;
		}
		query += ";";
		
		JDBConnection connection = JDBConnection.getInstance();
		Statement statement;
		ResultSet result;
		try {
			statement = connection.getStatement();
			result = statement.executeQuery(query);
			if (!result.first()) {
				result = null;
			}
			statement.close();
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
		JDBConnection connection = JDBConnection.getInstance();
		Statement statement;
		try {
			statement = connection.getStatement();
			statement.executeQuery(query);
			statement.close();
		} catch (SQLException e) {
			if(!e.getMessage().equals("Aucun résultat retourné par la requête.")) {
				throw new ErrorConnectionException();
			}
		}
	}
	
	public void update(String newValueIn, String objectIn, String conditionIn) {
		
	}
}
