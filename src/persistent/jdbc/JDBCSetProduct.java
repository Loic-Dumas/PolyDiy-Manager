package persistent.jdbc;
/**
 * @author nassim vachor, loic
 * @version 1.0
 * @since 2016-03-21
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.SetProduct;
import persistent.factory.ProductFactory;
import persistent.factory.jdbcFactory.JDBCProductFactory;

public class JDBCSetProduct extends SetProduct {
	private JDBCComponent component = null;
	ProductFactory productFactory = new JDBCProductFactory();

	public JDBCSetProduct(int IDSeller) throws ErrorConnectionException, AlertDriver {
		super(IDSeller);
		this.component = new JDBCComponent();

		ResultSet result = this.component.select("*", "product p, product_category c", "c.id_category = p.id_category AND id_seller = '" + this.getIDSeller() + "'");
		try {
			while (result.next()) {
				this.addElement(result.getString("id_product"),
						this.productFactory.buildProduct(result.getInt("id_product"),result.getString("name"),
								result.getString("description"), result.getFloat("unitPrice"),
								result.getInt("stockQuantity"), result.getInt("id_seller"),
								result.getInt("id_category"), result.getString("title")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public JDBCSetProduct() throws ErrorConnectionException, AlertDriver {
		super(-1);
		this.component = new JDBCComponent();
		ResultSet result = this.component.select("*", "product p, product_category c", "c.id_category = p.id_category");
		try {
			while (result.next()) {
				this.addElement(result.getString("id_product"),
						this.productFactory.buildProduct(result.getInt("id_product"),result.getString("name"),
								result.getString("description"), result.getFloat("unitPrice"),
								result.getInt("stockQuantity"), result.getInt("id_seller"),
								result.getInt("id_category"), result.getString("title")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Boolean isExisting() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void insert() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub

	}

}
