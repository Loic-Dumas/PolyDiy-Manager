package login;

import common.PasswordErrorException;

public class FacadeAccount {
	public FacadeAccount() {
		
	}
	
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
