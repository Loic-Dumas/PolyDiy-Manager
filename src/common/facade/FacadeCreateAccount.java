package common.facade;

import logic.AccountRegister;

public class FacadeCreateAccount {
	public void createAccount(String login, String password, String email, String firstName, String lastName) 
			throws Exception {
		AccountRegister register = new AccountRegister();
		register.createAccount(login, password, email, firstName, lastName);
		register.registerAccount();
	}
}
