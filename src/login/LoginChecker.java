package login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import common.ErrorConnectionException;
import common.UnknowLoginException;

public class LoginChecker {
	private Account account = null;	
	
	public boolean isValidPassword(String password) {
		if (this.account == null) {
			throw new NullPointerException() ;
		}
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String hashPassword = "";
			for(byte b : hash) {
				hashPassword += String.format("%02x", b);
			}
			return hashPassword.equals(this.account.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false ;
		
	}
	
	public void createAccount(String login ) throws ErrorConnectionException, UnknowLoginException {
		AccountFactory factory = new JDBCAccountFactory();
		this.account = factory.build(login);
	}
	
	public Account getAccount(){
		return this.account;
	}

}
