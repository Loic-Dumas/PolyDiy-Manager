package persistent.abstractclass;

/**
 * An account contain a login, a password and and ID.
 * The constructor need a login (String).
 * 
 * @author loicd_000 
 * @version 1.0
 * @since 2016-03-02
 */

/**
 * @author Faustine
 * @version 2.0
 * @since 2016-03-24
 */

public abstract class Account implements InterfaceModel { 
	
	protected String login = "";
	protected String password = "";
	protected int ID = -1;
	protected String email = "";
	protected String firstName = "";
	protected String lastName = "";
	protected String addressRoad ="";
	protected String addressCity="";
	protected String addressPostal="";
	
	public Account() {
	}
	
	/**
	 * @return the login of the account 
	 */
	public String getLogin() {
		return this.login;
	}
	
	/**
	 * @return the password of the account 
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @return the id of the account
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * @return the email of the account
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * @return the first name of the account
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * @return the last name of the account
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * @return the address city of the account
	 */
	public String getAddressCity() {
		return this.addressCity;
	}
	/**
	 * @return the address road of the account
	 */
	public String getAddressRoad() {
		return this.addressRoad;
	}
	/**
	 * @return the address postal of the account
	 */
	public String getAddressPostal() {
		return this.addressPostal;
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

	public void setRoad(String road) {
		this.addressRoad = road;
	}
	public void setCity(String city) {
		this.addressCity = city;
	}
	public void setPostalCode(String postalCode) {
		this.addressPostal = postalCode;
	}
}
