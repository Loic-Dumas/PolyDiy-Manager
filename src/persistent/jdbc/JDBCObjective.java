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
import persistent.abstractclass.Objective;

public class JDBCObjective extends Objective {
	private JDBCComponent component = null;
	
	public JDBCObjective() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "objective",
				new SQLCondition(Arrays.asList("id_objective"), 
								Arrays.asList(Integer.toString(this.idObjective))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "objective",
				new SQLCondition(Arrays.asList("title", "description", "deadline", "facultativ_id_activity", "id_category", "id_user"), 
								Arrays.asList(this.title, this.description, this.deadline, Integer.toString(this.facultativIdActivity), 
										Integer.toString(this.idCategory), Integer.toString(this.idUser))));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "objective", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				result.first();
				if (result.next()) {
					throw new NotUniqueAttribute(columnNames, "objective");
				} else {
					result.first();
				}
				this.idObjective = result.getInt("id_objective");
				this.title = result.getString("title");
				this.description = result.getString("description");
				this.deadline = result.getString("deadline");
				this.facultativIdActivity = result.getInt("facultativ_id_activity");
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
			this.component.insert("task(title, description, deadline, facultativ_id_activity, id_category, id_user)", 
									"'" + this.title + "', '" + this.description + "','" + this.deadline + "','" 
									+ this.facultativIdActivity + "', '" + this.idCategory + "','" + this.idUser + "'");
		} else {
			throw new AlreadyExistTuple("objective");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(title, description, deadline, facultativ_id_activity, id_category, id_user) = ('" 
								+ this.title + "', '" + this.description + "','" + this.deadline + "','" 
								+ this.facultativIdActivity + "', '" + this.idCategory + "','" + this.idUser + "')", 
									"objective", new SQLCondition());
		} else {
			throw new NotExistingTuple("objective");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("objective",
					new SQLCondition(Arrays.asList("id_objective"), 
									Arrays.asList(Integer.toString(this.idObjective))));
		} else {
			throw new NotExistingTuple("objective");
		}
	}

}
