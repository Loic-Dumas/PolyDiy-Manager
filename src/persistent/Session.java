package persistent;

import common.AbstractModel;
import common.exception.ErrorConnectionException;

public abstract class Session extends AbstractModel{
	protected int ID;
	protected String token;

	public abstract void generateToken() throws ErrorConnectionException;
	
	public int getID() {
		return this.ID;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}
