package logic.account;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.abstractclass.Account;
import persistent.abstractclass.Seller;
import persistent.abstractclass.User;
import persistent.factory.SellerProfilFactory;
import persistent.factory.SessionFactory;
import persistent.factory.jdbcFactory.JDBCSellerProfilFactory;
import persistent.factory.jdbcFactory.JDBCSessionFactory;

public class AccountRegister {
	private Account account = null;
	private User user = null;
	private Seller seller = null;
	
	public void createAccount(String login, String password, String email, String firstName, String lastName, 
								Boolean isUser, Boolean isSeller) throws ErrorConnectionException, AlertDriver {
		SessionFactory factory = new JDBCSessionFactory();
		this.account = factory.buildAccount(login, password, email, firstName, lastName);
		
		SellerProfilFactory factory2 = new JDBCSellerProfilFactory();
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
		
		// TODO create cart
	}
}
