package common.facade;

import common.exception.ErrorConnectionException;
import common.exception.ErrorPasswordException;
import logic.session.LoginChecker;
import logic.session.SessionHandler;

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
	 * This function connect the user.
	 * And return a token of the connection.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 * @param String : Login 
	 * @param String : password
	 * @return String : the token of the connection is returned.
	 */
	public String login(String login, String password) throws Exception {
		String token = null;
		LoginChecker checker = new LoginChecker();
		checker.generateAccount(login);
		if(checker.isValidPassword(password)) {
			SessionHandler handler = new SessionHandler();
			token = handler.login(checker.getAccount().getID());
		} else {
			throw new ErrorPasswordException();
		}
		return token;
	}
	
	public void logout(String token) throws ErrorConnectionException {
		SessionHandler handler = new SessionHandler();
		handler.logout(token);
	}
	
}
