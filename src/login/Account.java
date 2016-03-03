package login;

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
