package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.list.SetInfoWishList;
import persistent.abstractclass.list.WishListInfo;

/**
 * The JDBCImplementation of a SetInfoWishList
 * @author loicd_000
 *
 */
public class JDBCSetInfoWishList extends SetInfoWishList {
	private JDBCComponent component = null;
	
	
	/**
	 * @param IDUser
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	public JDBCSetInfoWishList(int IDUser) throws ErrorConnectionException, AlertDriver {
		super(IDUser);
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
					this.addElement(result.getString("label"),
							new WishListInfo(result.getInt("id_wishList"), result.getInt("id_user"), result.getString("label")));
				} while (result.next());
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
	}


}
