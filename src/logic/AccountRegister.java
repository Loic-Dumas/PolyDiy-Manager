package logic;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ProfilFactory;
import common.factory.SessionFactory;
import common.factory.jdbcFactory.JDBCProfilFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Account;
import persistent.Seller;
import persistent.User;

public class AccountRegister {
	private Account account = null;
	private User user = null;
	private Seller seller = null;
	
	public void createAccount(String login, String password, String email, String firstName, String lastName, 
								Boolean isUser, Boolean isSeller) throws ErrorConnectionException, AlertDriver {
		SessionFactory factory = new JDBCSessionFactory();
		this.account = factory.buildAccount(login, password, email, firstName, lastName);
		
		ProfilFactory factory2 = new JDBCProfilFactory();
		if(isUser) {
			this.user = factory2.buildUserEmpty();
		}
		if(isSeller) {
			this.seller = factory2.buildSellerEmpty();
		}
	}
	
	public void registerAccount() throws Exception {
		// TODO faire les regex sur chaque élément
		this.account.insert();
		this.user.setIDaccount(this.account.getID());
		this.seller.setIDaccount(this.account.getID());
		this.user.insert();
		this.seller.insert();
	}
}
