package persistent.jdbc;

import java.sql.ResultSet;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.User;

public class JDBCUser extends User {
	private JDBCComponent component = null;
	
	public JDBCUser() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}
	
	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "User_account", "Id_account = '" + this.ID + "'");
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			this.component.insert("User_account(id_account)", "'" + this.IDaccount + "'");
			} else {
			throw new AlreadyExistTuple("User");
		}
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub

	}

}
