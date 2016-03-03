package login;

import common.ErrorConnectionException;
import common.ErrorPasswordException;
import common.SessionErrorException;
import common.UnknowLoginException;

public class FacadeAccount {
	public FacadeAccount() {
		
	}
	
	public String login(String login, String password) throws ErrorConnectionException, UnknowLoginException, SessionErrorException, ErrorPasswordException {
		LoginChecker checker = new LoginChecker();
		checker.createAccount(login);
		if ( checker.isValidPassword(password) ) {
			SessionGenerator generator = new SessionGenerator();
			return generator.generateSession(checker.getAccount().getID());
		} else {
			throw new ErrorPasswordException();
		}
		
	}
	
}
