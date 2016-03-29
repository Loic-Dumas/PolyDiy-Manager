package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import common.jdbc.JDBCComponent;
import persistent.list.WishList;

public class JDBCWishList extends WishList {
	private JDBCComponent component = null;
	ProductFactory productFactory = new JDBCProductFactory();
	
	public JDBCWishList(int IDWishList) throws ErrorConnectionException, AlertDriver {
		super(IDWishList);
		this.component = new JDBCComponent();
		try {
			//we get all items of the wish list.
			System.out.println("\nJe prepare le ResultSet pour la création de ma WishList");
			ResultSet result = this.component.select(
					"i.id_wishlist, i.id_product, i.quantity, i.unitPrice, w.label", 
					"wishlist w, item_wishlist i", 
					"w.id_wishlist = '" + IDWishList + "' AND i.id_wishlist = w.id_wishlist" );
			
			//we add the label (name) of the wish list
			if (result.first()) {
				this.setLabel(result.getString("label"));	
				System.out.println("J'ai ajouté le nom de ma wishlist : " + this.getLabel());
			} else {
				System.err.println("No wish list returned.");
			}
			//we add all the elements found to the set
			do {
				System.out.println("\nJ'essaye d'ajouter un produit à ma wishlist");
				try {
					this.addElement( String.valueOf(result.getInt("id_product")) ,
							productFactory.buildProductWishList( result.getInt("id_product"), result.getInt("id_wishlist"), 
									result.getInt("quantity"), result.getInt("unitPrice")));
					
				} catch (UnknownIDProductException e) {
					System.err.println("Impossible to create the product with id : " + result.getInt("id_product"));
					e.printStackTrace();
				} 
			} while(result.next());
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
		
		
	}

	@Override
	public Boolean isExisting() throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		return null;
	}

	@Override
	public Boolean haschanged() throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		return null;
	}

	@Override
	public void loadFromIntKey(String name, int value) throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		
	}

	@Override
	public void loadFromStringKey(String name, String value) throws Exception {
		// TODO JDBCWishList  Auto-generated method stub
		
	}

	@Override
	public void insert() throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		
	}

	@Override
	public void delete() throws Exception {
		// TODO JDBCWishList Auto-generated method stub
		
	}

}
