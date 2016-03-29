package persistent;

import common.InterfaceModel;

/**
 * An account contain a login, a password and and ID.
 * The constructor need a login (String).
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 */
public abstract class Account implements InterfaceModel { 
	
	protected String login = "";
	protected String password = "";
	protected int ID = -1;
	protected String email = "";
	protected String firstName = "";
	protected String lastName = "";
	
	public Account() {
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
