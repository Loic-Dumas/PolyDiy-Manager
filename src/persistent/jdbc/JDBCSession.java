package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.SessionErrorException;
import common.jdbc.JDBCComponent;
import common.jdbc.JDBConnection;
import persistent.Session;

public class JDBCSession extends Session {
	private JDBCComponent component = new JDBCComponent();
	
	public JDBCSession(int ID) {
		this.ID = ID;
	}
	
	public JDBCSession(String token) {
		this.token=token;
	}
	
	public JDBCSession(String token, int ID) {
		this.ID = ID;
		this.token = token;
	}

	@Override
	public void login() throws ErrorConnectionException, SessionErrorException {
		ResultSet result = null;
		try {
			result = this.component.select("*", "Session", "id=" + this.ID);
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		}
		if(result == null) {
			this.token = this.generateSession(ID);
		} else {
			throw new SessionErrorException(this.ID);
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
	
	private String generateSession(int ID) throws SessionErrorException, ErrorConnectionException {
		JDBConnection connection = JDBConnection.getInstance();
		String token = "";
		try {
			String query = "SELECT * FROM Session WHERE id='" + ID + "';";
			Statement state = connection.getStatement();
			ResultSet result = state.executeQuery(query);
			if(!result.next()) {
				do {
					result.close();
					token = UUID.randomUUID().toString();
					query = "SELECT * FROM Session WHERE Token='" + token + "';";
					result = state.executeQuery(query);
				} while(result.next());
				query = "INSERT INTO Session VALUES('" + token + "', '" + ID + "');";
				state.executeUpdate(query);
				result.close();
				state.close();
			} else {
				throw new SessionErrorException(ID);
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
		return token;
	}
}
