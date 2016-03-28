package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.exception.loadFromIntKeyException;
import common.exception.loadFromStringKeyException;
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
	private JDBCComponent component = null;
	
	public JDBCAccount() throws ErrorConnectionException, AlertDriver{
		super();
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() {
		ResultSet result = this.component.select("*", "Account", "ID = '" + this.ID + "'");
		return result != null;
	}

	@Override
	public void loadFromIntKey(String name, int value) throws NotUniqueAttribute, loadFromIntKeyException {
		ResultSet result = null;

		result = this.component.select("*", "Account", name + "=" + value);
		
		if(result != null) {
			try {
				result.first();
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Account");
				} else {
					result.first();
				}
				this.login = result.getString("login");
				this.password = result.getString("password");
				this.ID = result.getInt("ID");
				this.email = result.getString("email");
				this.firstName = result.getString("firstName");
				this.lastName = result.getString("lastName");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new loadFromIntKeyException("Account", name, value);
		}
	}

	@Override
	public void loadFromStringKey(String name, String value) throws NotUniqueAttribute, loadFromStringKeyException {
		ResultSet result = null;

		result = this.component.select("*", "Account", name + "='" + value + "'");
		
		if(result != null) {
			try {
				result.first();
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Account");
				} else {
					result.first();
				}
				this.login = result.getString("login");
				this.password = result.getString("password");
				this.ID = result.getInt("ID");
				this.email = result.getString("email");
				this.firstName = result.getString("firstName");
				this.lastName = result.getString("lastName");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new loadFromStringKeyException("Account", name, value);
		}
	}

	@Override
	public void insert() throws AlreadyExistTuple {
		if(!this.isExisting()) {
			this.component.insert("Account", "'" + this.login + "', '" + this.password + "', '" + this.email 
				                 	+ "', '" + this.firstName + "', '" + this.lastName + "'");
		} else {
			throw new AlreadyExistTuple("Account");
		}
	}

	@Override
	public void update() throws NotExistingTuple {
		if(this.isExisting()) {
			this.component.update("(login, password, ID, email, firstName, lastName) = (" + this.login + "," 
		                           + this.password + "," + this.ID + "," + this.firstName + "," + this.lastName + ")",
		                           "Account", "");
		} else {
			throw new NotExistingTuple("Account");
		}
	}

	@Override
	public void delete() throws NotExistingTuple {
		if(this.isExisting()) {
			this.component.delete("Account", "ID=" + this.ID);
		} else {
			throw new NotExistingTuple("Account");
		}
	}
}
