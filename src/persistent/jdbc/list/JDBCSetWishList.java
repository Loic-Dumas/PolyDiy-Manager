package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.list.SetWishList;
import persistent.factory.ListFactory;
import persistent.factory.jdbcFactory.JDBCListFactory;

/**
 * The JDBCImplementation of a setWishList
 * @author loicd_000
 *
 */
public class JDBCSetWishList extends SetWishList {
	private JDBCComponent component = null;
	ListFactory wishListFactory = new JDBCListFactory();

	public JDBCSetWishList(int idUser) throws ErrorConnectionException, AlertDriver {
		super(idUser);
		this.component = new JDBCComponent();

		try {
			// we get all items of the wish list.
			ResultSet result = this.component.select("*", // SELECT
					"wishlist", // FROM
					"id_user = '" + this.IDUser + "' AND label != 'Cart' "); // WHERE

			if (!result.first()) {
				System.out.println("No wish list returned.");
			}
			else {
				// we add all the wish lists found to the set
				do {
					this.addElement(String.valueOf(result.getInt("id_wishList")),
							wishListFactory.buildWishList(result.getInt("id_wishList")));
					// Maybe I can do a cleaner version who don't construct all
					// the wishList
				} while (result.next());
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#insert()
	 */
	@Override
	public void insert() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

	}

	
	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#delete()
	 */
	@Override
	public void delete() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

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

}
