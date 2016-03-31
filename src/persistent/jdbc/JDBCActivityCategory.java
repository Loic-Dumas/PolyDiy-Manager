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
import persistent.ActivityCategory;

public class JDBCActivityCategory extends ActivityCategory {
	private JDBCComponent component = null;
	
	public JDBCActivityCategory() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "activity_category",
				new SQLCondition(Arrays.asList("id_activity_category"), 
								Arrays.asList(Integer.toString(this.idActivityCategory))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "activity_category",
				new SQLCondition(Arrays.asList("label", "short_description", "description"), 
								Arrays.asList(this.label, this.shortDescription, this.description)));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "activity_category", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				if(result.first()) {
					if (result.next()) {
						throw new NotUniqueAttribute(columnNames, "activity_category");
					} else {
						result.first();
					}
					this.idActivityCategory = result.getInt("id_activity_category");
					this.label = result.getString("label");
					this.shortDescription = result.getString("short_description");
					this.description = result.getString("description");
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
			this.component.insert("activity_category(label, short_description, description)", 
									"'" + this.label + "', '" + this.shortDescription + "', '" + this.description + "'");
		} else {
			throw new AlreadyExistTuple("activity_category");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(label, short_description, description) = ('" + this.label + "','" + this.shortDescription + "','" + this.description + "')", "activity_category", new SQLCondition());
		} else {
			throw new NotExistingTuple("activity_category");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("activity_category",
					new SQLCondition(Arrays.asList("id_activity_category"), 
									Arrays.asList(Integer.toString(this.idActivityCategory))));
		} else {
			throw new NotExistingTuple("activity_category");
		}
	}

}
