package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
			ResultSet result = this.component.select("*", "product", "id_product = '" + this.IDProduct + "'");
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
		ResultSet result = this.component.select("*", "item_wishlist ", "id_product = " + this.IDProduct );
		return result != null;
	}

	@Override
	public void insert() throws Exception {
		// TODO JDBCProductWishList Auto-generated method stub
		
	}

	@Override
	public void update() throws Exception {
		this.component = new JDBCComponent();
		if(this.isExisting()) {
			this.component.update("(id_product, name, description, unitPrice, stockQuantity) = (" + this.IDProduct + "," 
		                           + this.name + "," + this.description + "," + this.unitPrice + "," + this.stockQuantity + ")",
		                           "item_wishlist", "id_product = " + this.IDProduct + "AND id_wishlist = " + this.IDWishList );
		} else {
			throw new NotExistingTuple("item_wishlist");
		}
	}

	@Override
	public void delete() throws Exception {
		this.component = new JDBCComponent();
		this.component.delete("item_wishList", "id_product = " + this.IDProduct + " AND id_wishlist = " + this.IDWishList);
		
		
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
