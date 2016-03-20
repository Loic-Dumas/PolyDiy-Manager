package persistent.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.exception.ErrorConnectionException;
import common.exception.JDBCQueryException;
import common.exception.UnknownIDException;
import common.jdbc.JDBCComponent;
/**
 * The JDBC object of a product.
 * Request to the db the name, description, unitPrice and stockQuantity.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
import persistent.Product;

public class JDBCProduct extends Product {
	private JDBCComponent component = new JDBCComponent();

	public JDBCProduct(int ID) throws ErrorConnectionException, UnknownIDException, SQLException {
		super(ID);
		
		ResultSet result = null;
		try {
			result = this.component.select("*", "product", "id = " + this.ID);
			if (result.next()) {
				
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");
				
			} else {
				throw new UnknownIDException(ID);
			}
		} catch (JDBCQueryException e) {
			e.printStackTrace();
		}

			
		
		/* JDBConnection 
		String query = "SELECT * FROM product WHERE id = '" + ID + "';";
		JDBConnection connection = JDBConnection.getInstance();
		Statement statement;
		try {
			statement = connection.getStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");
				
			} else {
				throw new UnknownIDException(ID);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
		
		*/
	}

}
