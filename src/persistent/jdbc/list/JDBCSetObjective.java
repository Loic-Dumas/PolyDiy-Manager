package persistent.jdbc.list;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.abstractclass.list.SetObjective;
import persistent.factory.jdbcFactory.JDBCActivityFactory;

public class JDBCSetObjective extends SetObjective {
	private JDBCComponent component = null;
	
	public JDBCSetObjective(int idUser) throws Exception {
		this.idUser = idUser;
		this.component = new JDBCComponent();
		ResultSet result = this.component.select(Arrays.asList("*"), "Objective",
												new SQLCondition(Arrays.asList("id_user"), 
																Arrays.asList(Integer.toString(this.idUser))));
		if(result != null) {
			JDBCActivityFactory factory = new JDBCActivityFactory();
			while(result.next()) {
				this.addElement(Integer.toString(result.getInt("id_objective")), 
								factory.buildObjective(result.getInt("id_objective"), 
													result.getString("title"), result.getString("description"), 
													result.getString("deadline"), result.getInt("facultativ_id_activity"), 
													result.getInt("id_category"), result.getInt("id_user")));
			}
		}
	}

	@Override
	public Boolean isExisting() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

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
