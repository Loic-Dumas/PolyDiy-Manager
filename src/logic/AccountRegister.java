package logic;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.SessionFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Account;

public class AccountRegister {
	private Account account = null;
	private User user = null;
	private Seller seller = null;
	
	public void createAccount(String login, String password, String email, String firstName, String lastName, 
								Boolean isUser, Boolean isSeller) throws ErrorConnectionException, AlertDriver {
		SessionFactory factory = new JDBCSessionFactory();
		this.account = factory.buildAccount(login, password, email, firstName, lastName);
		
		ProfileFactory factory2 = new JDBCProfileFactory();
		if(isUser) {
			this.user = factory.buildUser(this.account.getID());
		}
		if(isSeller) {
			this.seller = factory.buildSeller(this.account.getID());
		}
	}
	
	public void registerAccount() throws Exception {
		// TODO faire les regex sur chaque élément
		this.account.insert();
		this.user.insert();
		this.seller.insert();
	}
}
