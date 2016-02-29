package login;

public abstract class Account {
	
	protected String login;
	protected String password; // le bon mot de passe (celui de la DB)
	protected String ID;
	
	public String getPassword() {
		return this.password;
	}

}
