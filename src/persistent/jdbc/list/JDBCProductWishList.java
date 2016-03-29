package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.UnknownIDProductException;
import common.jdbc.JDBCComponent;
import persistent.list.ProductWishList;

public class JDBCProductWishList extends ProductWishList{
	private JDBCComponent component = null;

	public JDBCProductWishList(int ID, int IDWishList, int quantity, float unitPrice) 
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		super(ID, IDWishList);
		this.component = new JDBCComponent();
				
		try {
			ResultSet result = this.component.select("*", "product", "id_product = '" + this.ID + "'");
			if (result.first()) {
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = unitPrice;
				this.quantity = quantity;
			} else {
				throw new UnknownIDProductException(ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "item_wishlist ", "id_product = " + this.ID );
		return result != null;
	}

	@Override
	public Boolean haschanged() throws Exception {
		return this.hasChanged;
	}

	@Override
	public void loadFromIntKey(String name, int value) throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		
	}

	@Override
	public void loadFromStringKey(String name, String value) throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		
	}

	@Override
	public void insert() throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		if(this.isExisting()) {
			this.component.update("(id_product, name, description, unitPrice, stockQuantity) = (" + this.ID + "," 
		                           + this.name + "," + this.description + "," + this.unitPrice + "," + this.stockQuantity + ")",
		                           "item_wishlist", "id_product = " + this.ID + "AND id_wishlist = " + this.IDWishList );
		} else {
			throw new NotExistingTuple("item_wishlist");
		}
	}

	@Override
	public void delete() throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		
	}

}
