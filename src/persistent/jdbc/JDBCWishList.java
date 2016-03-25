package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import common.jdbc.JDBCComponent;
import persistent.WishList;

public class JDBCWishList extends WishList {
	private JDBCComponent component = new JDBCComponent();
	ProductFactory productFactory = new JDBCProductFactory();
	
	public JDBCWishList(int ID) throws ErrorConnectionException {
		super(ID);
		try {
			//we get all items of the wish list.
			ResultSet result = this.component.select(
					"i.id_wishlist, i.id_product, i.quantity, i.unitPrice, w.label", 
					"wishlist w, item_wishlist i", 
					"w.id_wishlist = '" + ID + "' AND ' i.id_wishlist = w.id_wishlist" );
			
			//we add the label (name) of the wish list
			if (result.next()) {
				this.setLabel(result.getString("w.label"));	
			} else {
				System.err.println("No wish list returned.");
			}
			//we add all the elements found to the set
			do {
				try {
					//construct a product of the wish list
					this.addElement(productFactory.buildProductWishList(result.getInt("i.id_product"),
							result.getInt("i.quantity"),
							result.getInt("i.unitPrice")));
				} catch (UnknownIDProductException e) {
					System.err.println("Impossible to create the product with id : " + result.getInt("i.id_product"));
					e.printStackTrace();
				} 
			} while(result.next());
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		}
		
		
	}

}
