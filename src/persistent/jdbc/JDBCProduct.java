package persistent.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.exception.UnknownIDProductException;
import common.exception.loadFromIntKeyException;
import common.exception.loadFromStringKeyException;
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
	private JDBCComponent component = null;

	public JDBCProduct(int ID) throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		super(ID);
		this.component = new JDBCComponent();
	}

	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "Product", "id_product = " + this.ID );
		return result != null;
	}

	public void loadFromIntKey(String name, int value) throws loadFromIntKeyException, NotUniqueAttribute {
		ResultSet result = this.component.select("*", "product", name + " = " + value );
		
		try {
			if (result.first()) {
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Account");
				} else {
					result.first();
				}
				// load informations
				this.ID = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");			
				
				} else {
				throw new loadFromIntKeyException("Product", name, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public void loadFromStringKey(String name, String value) throws loadFromStringKeyException, NotUniqueAttribute  {
ResultSet result = this.component.select("*", "product", value +" = '" + value + "'");
		
		try {
			if (result.first()) {
				if(result.next()) {
					throw new NotUniqueAttribute(name, "Account");
				} else {
					result.first();
				}
				// load informations
				this.ID = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");			
				
				} else {
				throw new loadFromStringKeyException("Product", name, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			this.component.insert("product", "'" + this.name + "', '" + this.description 
					+ "', '"  + this.unitPrice + "', '" + this.stockQuantity + "'");
		} else {
			throw new AlreadyExistTuple("Product");
		}
	}

	@Override
	public void update() throws Exception {
		if(this.isExisting()) {
			this.component.update("(name, description, unitPrice, stockQuantity) = (" + this.name 
					+ "," + this.description + "," + this.unitPrice + "," + this.stockQuantity + ")",
		                           "Account", "id_product = " + this.ID);
		} else {
			throw new NotExistingTuple("Product");
		}
	}

	@Override
	public void delete() throws Exception {
		if(this.isExisting()) {
			this.component.delete("Product", " id_product = " + this.ID);
		} else {
			throw new NotExistingTuple("Product");
		}
	}

	@Override
	public Boolean hasChanged() throws Exception {
		return this.hasChanged;
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
