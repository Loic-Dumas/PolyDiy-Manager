package login;

public abstract class Account {
	
	protected String login;
<<<<<<< HEAD
	protected String password; // le bon mot de passe (celui de la DB)
	protected int ID;
	
	public Account(String login) {
=======
	protected String password; // the real password (present in db)
	protected int ID;
	
	public Account (String login) {
>>>>>>> 19d096cf176426501c504bd725533a34c2c0b4e0
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}
<<<<<<< HEAD

	public int getID() {
		return this.ID;
	}
=======
	
>>>>>>> 19d096cf176426501c504bd725533a34c2c0b4e0
}
