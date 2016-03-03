package login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ErrorConnectionException;
import common.IncorrectLoginException;
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
	
	public void createAccount(String login) throws UnknowLoginException, ErrorConnectionException, IncorrectLoginException {
		Pattern pattern = Pattern.compile("[[^ \\w] && [^ \\p{javaLowerCase}] && [^ \\p{javaUpperCase}]]");
		Matcher matcher = pattern.matcher(login);
		
		if(!matcher.find()) {
			AccountFactory factory = new JDBCAccountFactory();
			this.account = factory.build(login);
		} else {
			throw new IncorrectLoginException();
		}
	}
	
	public Account getAccount(){
		return this.account;
	}

}
