package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.jdbc.JDBCComponent;
import persistent.Session;

public class JDBCSession extends Session {
	private JDBCComponent component = null;
	
	public JDBCSession() throws ErrorConnectionException, AlertDriver {
		super();
		this.component = new JDBCComponent();
	}
	
	public void generateToken() throws ErrorConnectionException {
		try {
			do {
				this.token = UUID.randomUUID().toString();
			} while(this.isExisting());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "Session", "ID = '" + this.ID + "'");
		return result != null && result.first();
	}

	@Override
	public void loadFromIntKey(String name, int value) throws NotUniqueAttribute {
		ResultSet result = null;

		result = this.component.select("*", "Session", name + "=" + value);
		
		if(result != null) {
			try {
				result.first();
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Session");
				}
				this.ID = result.getInt("ID");
				this.token = result.getString("token");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void loadFromStringKey(String name, String value) throws NotUniqueAttribute {
		ResultSet result = null;

		result = this.component.select("*", "Session", name + "='" + value + "'");
		
		if(result != null) {
			try {
				result.first();
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Session");
				}
				this.ID = result.getInt("ID");
				this.token = result.getString("token");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			this.component.insert("Session", "'" + this.token + "', '" + this.ID + "'");
		} else {
			throw new AlreadyExistTuple("Session");
		}
	}

	@Override
	public void update() throws Exception {
		if(this.isExisting()) {
			this.component.update("(token, ID) = (" + this.token + "," + this.ID + ")", "Session", "");
		} else {
			throw new NotExistingTuple("Session");
		}
	}

	@Override
	public void delete() throws Exception {
		if(this.isExisting()) {
			this.component.delete("Session", "ID=" + this.ID);
		} else {
			throw new NotExistingTuple("Session");
		}
	}
}
