package persistent;

import common.exception.ErrorConnectionException;
import common.exception.SessionErrorException;

public abstract class Session {
	protected int ID;
	protected String token;

	public abstract void login() throws ErrorConnectionException, SessionErrorException;
	public abstract void logout() throws ErrorConnectionException;
	
	public int getID() {
		return this.ID;
	}
	
	public String getToken() {
		return this.token;
	}
}
