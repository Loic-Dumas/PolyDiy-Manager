package login;

import common.PasswordErrorException;

/**
 * This class contains a function to connect the user.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class FacadeAccount {
	public FacadeAccount() {
		
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
		String token = "";
		LoginChecker checker = new LoginChecker();
		checker.createAccount(login);
		
		int ID = checker.getAccount().getID();
		if(checker.isValidPassword(password)) {
			SessionGenerator generator = new SessionGenerator();	
			token = generator.generateSession(ID);
		} else {
			throw new PasswordErrorException();
		}
		return token;
	}
	
}
