package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import common.jdbc.JDBCComponent;
import persistent.Cart;

public class JDBCCart extends Cart {
	private JDBCComponent component = null;
	ProductFactory productFactory = new JDBCProductFactory();
	
	public JDBCCart(int ID) throws ErrorConnectionException, AlertDriver {
		super(ID);
		this.component = new JDBCComponent() ;
		
		this.setLabel("Cart");	
		
		try {
			//we get all items of the wish list.
			ResultSet result = this.component.select(
					"i.id_wishlist, i.id_product, i.quantity, i.unitPrice", 
					"wishlist w, item_wishlist i", 
					"w.id_wishlist = '" + ID + "' AND ' i.id_wishlist = w.id_wishlist" );
			
			//we add all the elements found to the set
			while(result.next()) {
				try {
					//construct a product of the wish list
					this.addElement(productFactory.buildProductWishList(result.getInt("i.id_product"),
							result.getInt("i.quantity"),
							result.getInt("i.unitPrice")));
				} catch (UnknownIDProductException e) {
					System.err.println("Impossible to create the product with id : " + result.getInt("i.id_product"));
					e.printStackTrace();
				} 
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		} 
		
		
	}
}
