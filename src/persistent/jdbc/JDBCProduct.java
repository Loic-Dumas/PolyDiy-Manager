package persistent.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.NotUniqueAttribute;
import common.exception.LoadFromIntKeyException;
import common.exception.LoadFromStringKeyException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.Product;

public class JDBCProduct extends Product {
	private JDBCComponent component = null;

	/**
	 * @param idPoduct
	 * @param name
	 * @param description
	 * @param unitPrice
	 * @param stockQuantity
	 * @param IDSeller
	 * @param IDCategory
	 * @param categoryName
	 */
	public JDBCProduct( /*int idPoduct,*/ String name, String description, float unitPrice, int stockQuantity, int IDSeller,
			int IDCategory, String categoryName) {
		super(IDSeller);
		//this.setIDProduct(idPoduct);
		this.setName(name);
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setStockQuantity(stockQuantity);
		this.setIDSeller(IDSeller);
		this.setIDCategory(IDCategory);
		this.setCategoryName(categoryName);
	}
	
	/**
	 * @param IDProduct
	 * @param IDSeller
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	public JDBCProduct(int IDProduct, int IDSeller) throws ErrorConnectionException, AlertDriver {
		super(IDProduct, IDSeller);
		
		this.component = new JDBCComponent();


		ResultSet result = this.component.select("*", "product p, product_category c", "id_product = "
		+ IDProduct  + "id_seller = "+ IDSeller + " AND c.id_category = p.id_category");

			
		try {
			if (result.first()) {
				// load informations
				this.IDProduct = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");
				this.IDCategory = result.getInt("id_seller");
				this.categoryName = result.getString("title");

			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @param IDProduct
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	public JDBCProduct(int IDProduct) throws ErrorConnectionException, AlertDriver {
		super(IDProduct);
		
		this.component = new JDBCComponent();

		ResultSet result = this.component.select("*", "product p, product_category c", "id_product = "
		+ IDProduct + " AND c.id_category = p.id_category");
		
		try {
			if (result.first()) {
				// load informations
				this.IDProduct = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");
				this.IDSeller = result.getInt("id_seller");
				this.IDCategory = result.getInt("id_seller");
				this.categoryName = result.getString("title");

			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "Product", "id_product = " + this.IDProduct);
		return result != null;
	}

	// not working
	public void loadFromIntKey(String name, int value) throws LoadFromIntKeyException, NotUniqueAttribute {
		ResultSet result = this.component.select("*", "product", name + " = " + value);

		try {
			if (result.first()) {
				if (result.next()) {
					throw new NotUniqueAttribute(name, "Product");
				} else {
					result.first();
				}
				// load informations
				this.IDProduct = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");

			} else {
				throw new LoadFromIntKeyException("Product", name, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param name
	 * @param value
	 * @throws LoadFromStringKeyException
	 * @throws NotUniqueAttribute
	 */
	public void loadFromStringKey(String name, String value) throws LoadFromStringKeyException, NotUniqueAttribute {
		ResultSet result = this.component.select("*", "product", value + " = '" + value + "'");

		try {
			if (result.first()) {
				if (result.next()) {
					throw new NotUniqueAttribute(name, "Product");
				} else {
					result.first();
				}
				// load informations
				this.IDProduct = result.getInt("id_product");
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = result.getFloat("unitPrice");
				this.stockQuantity = result.getInt("stockQuantity");

			} else {
				throw new LoadFromStringKeyException("Product", name, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#insert()
	 */
	@Override
	public void insert() throws Exception {
		if (!this.isExisting()) {
			this.component.insert("product", "'" + this.name + "', '" + this.description + "', '" + this.unitPrice
					+ "', '" + this.stockQuantity + "'");
		} else {
			throw new AlreadyExistTuple("Product");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#update()
	 */
	@Override
	public void update() throws Exception {
		if (this.isExisting()) {
			this.component.update(
					"(name, description, unitPrice, stockQuantity) = (" + this.name + "," + this.description + ","
							+ this.unitPrice + "," + this.stockQuantity + ")",
					"Product", "id_product = " + this.IDProduct);
		} else {
			throw new NotExistingTuple("Product");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#delete()
	 */
	@Override
	public void delete() throws Exception {
		if (this.isExisting()) {
			this.component.delete("Product", " id_product = " + this.IDProduct);
		} else {
			throw new NotExistingTuple("Product");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#hasChanged()
	 */
	@Override
	public Boolean hasChanged() throws Exception {
		return this.hasChanged;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#loadFromKeys(java.util.List, java.util.List)
	 */
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub

	}

}
