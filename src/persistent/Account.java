package persistent;

/**
 * An account contain a login, a password and and ID.
 * The constructor need a login (String).
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 */
public abstract class Account { 
	
	protected String login;
	protected String password; // the real password (present in db)
	protected String firstName;
	protected String lastName;
	protected int ID;
	
	public Account (String login) {
		this.login = login;
	}
	
	public Account (int ID) {
		this.ID = ID;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
}
