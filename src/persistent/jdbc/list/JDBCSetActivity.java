package persistent.jdbc.list;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.abstractclass.list.SetActivity;
import persistent.factory.jdbcFactory.JDBCActivityFactory;

/**
 * JDBC version of SetActivity
 * @author loicd_000
 *
 */
public class JDBCSetActivity extends SetActivity {
	private JDBCComponent component = null;
	
	/**
	 * @param idUser
	 * @throws Exception
	 */
	public JDBCSetActivity(int idUser) throws Exception {
		this.idUser = idUser;
		this.component = new JDBCComponent();
		ResultSet result = this.component.select(Arrays.asList("*"), "Activity",
												new SQLCondition(Arrays.asList("id_user"), 
																Arrays.asList(Integer.toString(this.idUser))));
		if(result != null) {
			JDBCActivityFactory factory = new JDBCActivityFactory();
			while(result.next()) {
				this.addElement(Integer.toString(result.getInt("id_activity")), 
								factory.buildActivity(result.getInt("id_activity"), 
													result.getString("title"), result.getString("description"), 
													result.getString("deadline"), result.getInt("id_activity_category"), 
													result.getInt("id_user")));
			}
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#hasChanged()
	 */
	@Override
	public Boolean hasChanged() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#loadFromKeys(java.util.List, java.util.List)
	 */
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#insert()
	 */
	@Override
	public void insert() throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#delete()
	 */
	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub

	}

}
