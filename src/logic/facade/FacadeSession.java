package logic.facade;

import common.exception.ErrorPasswordException;
import logic.session.LoginChecker;
import logic.session.SessionHandler;
import persistent.abstractclass.Session;

/**
 * This class contains a function to connect the user.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class FacadeSession {
	public FacadeSession() {

	}

	/**
	 * This function connect the user. And return a token of the connection.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 * @param String
	 *            : Login
	 * @param String
	 *            : password
	 * @return String : the token of the connection is returned.
	 */
	public Session login(String login, String password) throws Exception {
		Session session = null;
		LoginChecker checker = new LoginChecker();
		checker.generateAccount(login);
		if (checker.isValidPassword(password)) {
			SessionHandler handler = new SessionHandler();
			session = handler.login(checker.getAccount().getID());
		} else {
			throw new ErrorPasswordException();
		}
		return session;
	}
	
	public void logout(int ID) throws Exception {
		SessionHandler handler = new SessionHandler();
		handler.logout(ID);
	}

}
