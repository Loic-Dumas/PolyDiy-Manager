package logic.facade;

import common.exception.InvalidTypeAccount;
import logic.account.AccountRegister;

public class FacadeCreateAccount {
	public void createAccount(String login, String password, String email, String firstName, String lastName, 
								Boolean isUser, Boolean isSeller) 
			throws Exception {
		AccountRegister register = new AccountRegister();
		if(!isUser && !isSeller) {
			throw new InvalidTypeAccount();
		}
		register.createAccount(login, password, email, firstName, lastName, isUser, isSeller);
		register.registerAccount();
	}
}
