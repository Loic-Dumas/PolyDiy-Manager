package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.UnknownIDProductException;
import common.jdbc.JDBCComponent;
import persistent.ProductWishList;

public class JDBCProductWishList extends ProductWishList{
	private JDBCComponent component = new JDBCComponent();

	public JDBCProductWishList(int ID, int quantity, float unitPrice) throws ErrorConnectionException, UnknownIDProductException {
		super(ID);
				
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
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
