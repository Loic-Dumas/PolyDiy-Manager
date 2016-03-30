package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.Account;

/**
 * This class extends from account. 
 * (So you need the login(String) to create the account)
 * When you create the JDBCaccount you connect to the database to get the real password and the id.
 * If the login don't exist, throws UnknowLoginExcetion.
 * If the connection fail, throws ErrorConnectionException.
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
		ResultSet result = null;
		try {
			result = this.component.select(Arrays.asList("*"), "Account",
													new SQLCondition(Arrays.asList("ID"),
																	Arrays.asList(Integer.toString(this.ID))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result != null;
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "Account",
												new SQLCondition(Arrays.asList("login", "password", "ID", "email", "firstName", "lastName"),
														Arrays.asList(this.login, this.password, Integer.toString(this.ID), this.email, this.firstName, this.lastName)));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws NotUniqueAttribute, NotExistingTuple {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "Account", 
											new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(result != null) {
			try {
				if(result.first()) {
					if(result.next()) {
						throw new NotUniqueAttribute(columnNames, "Account");
					} else {
						result.first();
					}
					this.login = result.getString("login");
					this.password = result.getString("password");
					this.ID = result.getInt("ID");
					this.email = result.getString("email");
					this.firstName = result.getString("firstName");
					this.lastName = result.getString("lastName");
				} else {
					throw new NotExistingTuple("Account");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			try {
				this.component.update("(login, password, ID, email, firstName, lastName) = (" + this.login + "," 
				                       + this.password + "," + this.ID + "," + this.email + "," + this.firstName + "," + this.lastName + ")",
				                       "Account", new SQLCondition(Arrays.asList("ID"),
				                    		   						Arrays.asList(Integer.toString(this.ID))));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new NotExistingTuple("Account");
		}
	}

	@Override
	public void delete() throws NotExistingTuple {
		if(this.isExisting()) {
			try {
				this.component.delete("Account", new SQLCondition(Arrays.asList("ID"),
																	Arrays.asList(Integer.toString(this.ID))));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new NotExistingTuple("Account");
		}
	}
}
