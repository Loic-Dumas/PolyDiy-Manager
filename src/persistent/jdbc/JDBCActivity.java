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
import persistent.Activity;

public class JDBCActivity extends Activity {
	private JDBCComponent component = null;
	
	public JDBCActivity() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "activity",
				new SQLCondition(Arrays.asList("id_activity"), 
								Arrays.asList(Integer.toString(this.idActivity))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "activity",
				new SQLCondition(Arrays.asList("title", "description", "deadline", "id_activity_category", "id_user"), 
								Arrays.asList(this.title, this.description, this.deadline, Integer.toString(this.idActivityCategory), Integer.toString(this.idUser))));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "activity", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				result.first();
				if (result.next()) {
					throw new NotUniqueAttribute(columnNames, "activity");
				} else {
					result.first();
				}
				this.idActivity = result.getInt("id_activity");
				this.title = result.getString("title");
				this.description = result.getString("description");
				this.deadline = result.getString("deadline");
				this.idActivityCategory = result.getInt("id_activity_category");
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
			this.component.insert("activity(title, description, deadline, id_activity_category, id_user)", 
									"'" + this.title + "', '" + this.description + "', '" + this.deadline + "','"
									+ this.idActivityCategory + "','" + this.idUser + "'");
		} else {
			throw new AlreadyExistTuple("activity");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(title, description, deadline, id_activity_category, id_user) = ('" 
									+ this.title + "', '" + this.description + "', '" + this.deadline + "'" 
									+ this.idActivityCategory + "','" + this.idUser + "')", "activity", 
									new SQLCondition());
		} else {
			throw new NotExistingTuple("activity");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("objective",
					new SQLCondition(Arrays.asList("facultativ_id_activity"),
									Arrays.asList(Integer.toString(this.idActivity))));
			this.component.delete("task",
					new SQLCondition(Arrays.asList("id_activity"),
									Arrays.asList(Integer.toString(this.idActivity))));
			this.component.delete("activity",
					new SQLCondition(Arrays.asList("id_activity"), 
									Arrays.asList(Integer.toString(this.idActivity))));
		} else {
			throw new NotExistingTuple("activity");
		}
	}

}
