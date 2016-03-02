package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import common.JDBConnection;
import common.PasswordErrorException;
import common.SessionErrorException;

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
