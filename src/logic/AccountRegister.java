package logic;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.JDBCSessionFactory;
import common.factory.SessionFactory;
import persistent.Account;

public class AccountRegister {
	private Account account = null;
	
	public void createAccount(String login, String password, String email, String firstName, String lastName) throws ErrorConnectionException, AlertDriver {
		SessionFactory factory = new JDBCSessionFactory();
		this.account = factory.buildAccount(login, password, email, firstName, lastName);
	}
	
	public void registerAccount() throws Exception {
		// TODO faire les regex sur chaque élément
		this.account.insert();
	}
}
