package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.exception.SessionErrorException;
import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.Session;

public class JDBCSession extends Session {
	private JDBCComponent component = null;

	public JDBCSession() throws ErrorConnectionException, AlertDriver {
		super();
		this.component = new JDBCComponent();
	}

	public void generateToken() throws Exception {
		if(this.isExisting()) {
			throw new SessionErrorException(this.ID);
		} else {
			try {
				ResultSet result;
				Boolean validToken = false;
				do {
					this.token = UUID.randomUUID().toString();
					result = this.component.select(Arrays.asList("*"), "Session",
											new SQLCondition(Arrays.asList("token"), Arrays.asList(this.token)));
					validToken = (result == null) || (!result.first());
				} while (!validToken);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "Session",
				new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "Session",
				new SQLCondition(Arrays.asList("id_account", "token"), Arrays.asList(Integer.toString(this.ID), this.token)));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws NotUniqueAttribute {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "Session", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				result.first();
				if (result.next()) {
					throw new NotUniqueAttribute(columnNames, "Session");
				} else {
					result.first();
				}
				this.ID = result.getInt("id_account");
				this.token = result.getString("token");

				result = this.component.select(Arrays.asList("login"), "Account",
						new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
				if (result.first()) {
					this.login = result.getString("login");
				}
				
				result = this.component.select(Arrays.asList("id_user"), "User_account",
						new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
				if (result.first()) {
					this.ID_user = result.getInt("id_user");
				}

				result = this.component.select(Arrays.asList("id_seller"), "Seller_account",
						new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
				if (result.first()) {
					this.ID_seller = result.getInt("id_seller");
				}
				
				result = this.component.select(Arrays.asList("id_admin"), "Admin_account",
						new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
				if (result.first()) {
					this.ID_user = result.getInt("id_admin");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert() throws Exception {
		if (!this.isExisting()) {
			this.component.insert("Session", "'" + this.token + "', '" + this.ID + "'");
		} else {
			throw new AlreadyExistTuple("Session");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(token, id_account) = (" + this.token + "," + this.ID + ")", "Session", new SQLCondition());
		} else {
			throw new NotExistingTuple("Session");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("Session",
					new SQLCondition(Arrays.asList("id_account"), Arrays.asList(Integer.toString(this.ID))));
		} else {
			throw new NotExistingTuple("Session");
		}
	}
}
