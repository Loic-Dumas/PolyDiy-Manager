package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.UnknownLoginException;
import common.jdbc.JDBCComponent;
import persistent.Account;

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
	private JDBCComponent component = new JDBCComponent();
	
	public JDBCAccount(String login) throws ErrorConnectionException, UnknownLoginException {
		super(login);
		try {
			ResultSet result = this.component.select("*", "Account", "login = '" + login + "'");
			if (result.first()) {
				this.password = result.getString("password");
				this.ID = result.getInt("id");
			} else {
				throw new UnknownLoginException(login);
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		}
	}
}
