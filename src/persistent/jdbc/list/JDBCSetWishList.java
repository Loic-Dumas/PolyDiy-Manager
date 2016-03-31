package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.jdbc.JDBCComponent;
import persistent.list.SetWishList;

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

	@Override
	public Boolean isExisting() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub
		return null;
	}

	@Override
	public void insert() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

	}

	@Override
	public void update() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

	}

	@Override
	public void delete() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub

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

}
