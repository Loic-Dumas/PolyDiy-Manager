package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.SessionErrorException;
import common.jdbc.JDBCComponent;
import persistent.Session;

public class JDBCSession extends Session {
	private JDBCComponent component = null;
	
	public JDBCSession() throws ErrorConnectionException {
		this.component = new JDBCComponent();
	}
	
	public JDBCSession(int ID) throws ErrorConnectionException {
		this.component = new JDBCComponent();
		this.ID = ID;
	}
	
	public JDBCSession(String token) throws ErrorConnectionException {
		this.component = new JDBCComponent();
		this.token=token;
	}
	
	public JDBCSession(String token, int ID) throws ErrorConnectionException {
		this.component = new JDBCComponent();
		this.ID = ID;
		this.token = token;
	}

	@Override
	public void login() throws ErrorConnectionException, SessionErrorException {
		try {
			ResultSet result = this.component.select("*", "Session", "id=" + this.ID);
			if(result == null || !result.first()) {
				this.token = this.generateSession(ID);
			} else {
				throw new SessionErrorException(this.ID);
			}
		} catch (SQLException | JDBCQueryException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void logout() throws ErrorConnectionException {
		try {
			this.component.delete("Session", "id='" + this.ID + "' AND token='" + this.token + "'");
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		}
	}
	
	private String generateSession(int ID) throws ErrorConnectionException {
		String token = "";
		try {
			ResultSet result;
			do {
				token = UUID.randomUUID().toString();
				result = this.component.select("*", "Session", "Token='" + token + "'");
			} while(result != null && result.first());
			this.component.insert("Session", "'" + token + "', '" + ID + "'");
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return token;
	}
}
