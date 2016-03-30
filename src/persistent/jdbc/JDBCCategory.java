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
import persistent.Category;

public class JDBCCategory extends Category {
	private JDBCComponent component = null;
	
	public JDBCCategory() throws ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "category",
				new SQLCondition(Arrays.asList("id_category"), 
								Arrays.asList(Integer.toString(this.idCategory))));
		return result != null && result.first();
	}

	@Override
	public Boolean hasChanged() throws Exception {
		ResultSet result = this.component.select(Arrays.asList("*"), "category",
				new SQLCondition(Arrays.asList("title", "description"), 
								Arrays.asList(this.title, this.description)));
		return result != null && result.first();
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		ResultSet result = null;

		try {
			result = this.component.select(Arrays.asList("*"), "category", new SQLCondition(columnNames, columnValues));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (result != null) {
			try {
				result.first();
				if (result.next()) {
					throw new NotUniqueAttribute(columnNames, "category");
				} else {
					result.first();
				}
				this.idCategory = result.getInt("id_category");
				this.title = result.getString("title");
				this.description = result.getString("description");
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
			this.component.insert("category(title, description)", 
									"'" + this.title + "', '" + this.description + "'");
		} else {
			throw new AlreadyExistTuple("category");
		}
	}

	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update("(title, description) = ('" + this.title + "','" + this.description + "')", "category", new SQLCondition());
		} else {
			throw new NotExistingTuple("category");
		}
	}

	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("category",
					new SQLCondition(Arrays.asList("id_category"), 
									Arrays.asList(Integer.toString(this.idCategory))));
		} else {
			throw new NotExistingTuple("category");
		}
	}

}
