package persistent;

import common.InterfaceModel;
import common.exception.ErrorConnectionException;

public abstract class Session implements InterfaceModel{
	protected int ID;
	protected String token;
	
	protected String login;
	protected int ID_user = -1;
	protected int ID_seller = -1;
	protected int ID_admin = -1;
	
	public abstract void generateToken() throws ErrorConnectionException, Exception;
	
	public int getID() {
		return this.ID;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public int getIDUser() {
		return this.ID_user;
	}
	
	public int getIDSeller() {
		return this.ID_seller;
	}
	
	public int getIDAdmin() {
		return this.ID_admin;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setIDUser(int ID_user) {
		this.ID_user = ID_user;
	}
	
	public void setIDSeller(int ID_seller) {
		this.ID_seller = ID_seller;
	}
	
	public void setIDAdmin(int ID_admin) {
		this.ID_admin = ID_admin;
	}
}
