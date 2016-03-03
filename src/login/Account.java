package login;

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
	protected int ID;
	
	public Account (String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getID() {
		return this.ID;
	}
	
}
