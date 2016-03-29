package common.factory.jdbcFactory;

import java.util.Arrays;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.SessionFactory;
import persistent.Account;
import persistent.Session;
import persistent.jdbc.JDBCAccount;
import persistent.jdbc.JDBCSession;

public class JDBCSessionFactory extends SessionFactory {

	@Override
	public Account buildAccount(String loginIn) throws Exception {
		Account account = new JDBCAccount();
		account.loadFromKeys(Arrays.asList("login"), Arrays.asList(loginIn));
		return account;
	}

	@Override
	public Account buildAccount(String login, String password, String email, String firstName, String lastName) throws ErrorConnectionException, AlertDriver {
		Account account = new JDBCAccount();
		account.setLogin(login);
		account.setPassword(password);
		account.setEmail(email);
		account.setFirstName(firstName);
		account.setLastName(lastName);
		return account;
	}

	@Override
	public Session buildSessionWithID(int IDin) throws ErrorConnectionException, AlertDriver {
		Session session = new JDBCSession();
		session.setID(IDin);
		return session;
	}
}
