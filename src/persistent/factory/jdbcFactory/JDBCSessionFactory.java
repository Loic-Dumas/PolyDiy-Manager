package persistent.factory.jdbcFactory;

import java.util.Arrays;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.abstractclass.Account;
import persistent.abstractclass.Session;
import persistent.factory.SessionFactory;
import persistent.jdbc.JDBCAccount;
import persistent.jdbc.JDBCSession;

/**
 * To build an account or a session
 * @author Faustine
 *
 */
public class JDBCSessionFactory extends SessionFactory {

	@Override
	public Account buildAccount(String loginIn) throws Exception {
		Account account = new JDBCAccount();
		account.loadFromKeys(Arrays.asList("login"), Arrays.asList(loginIn));
		return account;
	}

	@Override
	public Account buildAccountWithID(int ID) throws Exception {
		Account account = new JDBCAccount();
		account.loadFromKeys(Arrays.asList("id_account"),Arrays.asList(Integer.toString(ID)));;
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
