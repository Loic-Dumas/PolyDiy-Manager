package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ErrorConnectionException;
import common.JDBConnection;
import common.UnknownLoginException;

public class JDBCAccount  extends Account {
	public JDBCAccount(String login) throws UnknownLoginException, ErrorConnectionException{
		super(login);
		
		JDBConnection connection = JDBConnection.getInstance();
		String query = "SELECT * FROM Account WHERE Login='" + login + "';";
		Statement state;
		try {
			state = connection.getStatement();
			ResultSet result = state.executeQuery(query);
			if(result.next()) {
				this.ID = result.getInt("Id");
				this.password = result.getString("Password");
			} else {
				throw new UnknownLoginException(login);
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
	}
}
