package logic.account;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String hashPassword = "";
			for(byte b : hash) {
				hashPassword += String.format("%02x", b);
			}
			this.account = factory.buildAccount(login, hashPassword, email, firstName, lastName);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
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
		this.account.loadFromKeys(Arrays.asList("login"), Arrays.asList(this.account.getLogin()));
		if(this.user != null) {
			this.user.setIDaccount(this.account.getID());
			this.user.insert();
		}
		if(this.seller != null) {
			this.seller.setIDaccount(this.account.getID());
			this.seller.insert();
		}
	}
}
