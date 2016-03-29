package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.jdbc.JDBCComponent;
import persistent.list.SetWishList;

public class JDBCSetWishList extends SetWishList {
	private JDBCComponent component = null;
	ListFactory wishListFactory = new JDBCListFactory();

	public JDBCSetWishList(int iDUser) throws ErrorConnectionException, AlertDriver {
		super(iDUser);
		this.component = new JDBCComponent();
		
		try {
			//we get all items of the wish list.
			ResultSet result = this.component.select(
					"*", //SELECT
					"wishlist", //FROM
					"id_user = '" + this.IDUser + "' AND label != 'Cart' " ); //WHERE
			
			if (!result.first()) {
				System.err.println("No wish list returned.");
			}
			//we add all the wish lists found to the set
			do {
				this.addElement( String.valueOf(result.getInt("id_wishList")) ,
						wishListFactory.buildWishList(result.getInt("id_wishList"))); 
				// Maybe I can do a cleaner version who don't construct all the wishList
			} while(result.next());
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
	public Boolean haschanged() throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub
		return null;
	}

	@Override
	public void loadFromIntKey(String name, int value) throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub
		
	}

	@Override
	public void loadFromStringKey(String name, String value) throws Exception {
		// TODO JDBCSetWishList Auto-generated method stub
		
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

}
