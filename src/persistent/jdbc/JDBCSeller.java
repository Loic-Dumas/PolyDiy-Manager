package persistent.jdbc;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.UnknownIDSellerException;
import common.jdbc.JDBCComponent;
import persistent.Seller;

public class JDBCSeller extends Seller{
	private JDBCComponent component = new JDBCComponent();

	public JDBCSeller(int ID) throws ErrorConnectionException, UnknownIDSellerException {
		super(ID);
		
		try {
			ResultSet result = this.component.select("*", "seller_account", "id = '" + this.ID + "'");
			if (result.first()) {
				this.nameShop = result.getString("nameShop");
				this.description = result.getString("description");
				this.siret = result.getString("siret");
				this.website = result.getString("website");			
			} else {
				throw new UnknownIDSellerException(ID);
			}
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
