package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.jdbc.JDBCComponent;
import persistent.ProductWishList;

public class JDBCProductWishList extends ProductWishList{
	private JDBCComponent component = null;

	public JDBCProductWishList(int ID, int quantity, float unitPrice) 
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		super(ID);
		this.component = new JDBCComponent();
				
		try {
			ResultSet result = this.component.select("*", "product", "id = '" + this.ID + "'");
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

}
