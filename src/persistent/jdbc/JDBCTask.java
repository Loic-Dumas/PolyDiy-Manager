package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.abstractclass.Task;

public class JDBCTask extends Task {
	private JDBCComponent component = null;
	
	public JDBCTask() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "task",
				new SQLCondition(Arrays.asList("id_task"), 
								Arrays.asList(Integer.toString(this.idTask))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "task",
				new SQLCondition(Arrays.asList("title", "id_activity", "id_category", "id_user"), 
								Arrays.asList(this.title, Integer.toString(this.idActivity), 
										Integer.toString(this.idCategory), Integer.toString(this.idUser))));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "task", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				result.first();
				if (result.next()) {
					throw new NotUniqueAttribute(columnNames, "task");
				} else {
					result.first();
				}
				this.idTask = result.getInt("id_task");
				this.title = result.getString("title");
				this.idActivity = result.getInt("id_activity");
				this.idCategory = result.getInt("id_category");
				this.idUser = result.getInt("id_user");
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
			this.component.insert("task(title, id_activity, id_category, id_user)", 
									"'" + this.title + "', '" + this.idActivity + "', '" + this.idCategory + "','"
									+ this.idUser + "'");
		} else {
			throw new AlreadyExistTuple("task");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(title, id_activity, id_category, id_user) = ('" + this.title + "', '" 
									+ this.idActivity + "', '" + this.idCategory + "','" + this.idUser + "')", 
									"task", new SQLCondition());
		} else {
			throw new NotExistingTuple("task");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("task",
					new SQLCondition(Arrays.asList("id_task"), 
									Arrays.asList(Integer.toString(this.idTask))));
		} else {
			throw new NotExistingTuple("task");
		}
	}

}
