package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import common.jdbc.JDBCComponent;
import persistent.list.Cart;

public class JDBCCart extends Cart {
	private JDBCComponent component = null;
	ProductFactory productFactory = new JDBCProductFactory();
	
	public JDBCCart(int IDUser) throws ErrorConnectionException, AlertDriver {
		super(IDUser);
		this.component = new JDBCComponent() ;
		
		this.setLabel("Cart");	
		
		try {
			//we get all items of the wish list.
			ResultSet result = this.component.select(
					"i.id_wishlist, i.id_product, i.quantity, i.unitPrice, w.label", 
					"wishlist w, item_wishlist i", 
					"w.id_user = '" + IDUser + "' AND i.id_wishlist = w.id_wishlist AND w.label = 'Cart' " );
			
			//we add all the elements found to the set
			while(result.next()) {
				try {
					//construct a product of the wish list
					this.addElement( String.valueOf(result.getInt("id_product")) ,
							productFactory.buildProductWishList(result.getInt("id_product"), result.getInt("id_wishlist"), 
									result.getInt("quantity"), result.getInt("unitPrice")));
					
				} catch (UnknownIDProductException e) {
					System.err.println("Impossible to create the product with id : " + result.getInt("id_product"));
					e.printStackTrace();
				} 
			}
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		} 
		
		
	}

	@Override
	public Boolean isExisting() throws Exception {
		// TODO JDBCCart Auto-generated method stub
		return null;
	}

	@Override
	public Boolean haschanged() throws Exception {
		// TODO JDBCCart Auto-generated method stub
		return null;
	}

	@Override
	public void loadFromIntKey(String name, int value) throws Exception {
		// TODO JDBCCart Auto-generated method stub
		
	}

	@Override
	public void loadFromStringKey(String name, String value) throws Exception {
		// TODO JDBCCart Auto-generated method stub
		
	}

	@Override
	public void insert() throws Exception {
		// TODO JDBCCart Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO JDBCCart Auto-generated method stub
		
	}

	@Override
	public void delete() throws Exception {
		// TODO JDBCCart Auto-generated method stub
		
	}
}
