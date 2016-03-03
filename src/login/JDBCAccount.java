package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ErrorConnectionException;
import common.JDBConnection;
import common.UnknowLoginException;

/**
 * This class extends from account. 
 * (So you need the login(String) to create the account)
 * When you create the JDBCaccount you connect to the database to get the real password and the id.
 * If the login don't exist, throws UnknowLoginExcetion.
 * If the connection fail, throws EroorConnectionException.
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 *
 */
public class JDBCAccount extends Account {
	public JDBCAccount(String login) throws ErrorConnectionException, UnknowLoginException {
		super(login);
		String query = "SELECT * FROM account WHERE login = '" + login + "';";
		JDBConnection connection = JDBConnection.getInstance();
		Statement statement;
		try {
			statement = connection.getStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				this.password = result.getString("password");
				this.ID = result.getInt("id");
				
			} else {
				throw new UnknowLoginException(login);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
		
	}
}
