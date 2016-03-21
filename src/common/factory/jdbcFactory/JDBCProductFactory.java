package common.factory.jdbcFactory;

import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import persistent.Product;
import persistent.ProductWishList;
import persistent.jdbc.JDBCProduct;
import persistent.jdbc.JDBCProductWishList;

public class JDBCProductFactory extends ProductFactory{

	@Override
	public Product buildProduct(int ID) throws ErrorConnectionException, UnknownIDProductException {
		return new JDBCProduct(ID);
	}

	@Override
	public ProductWishList buildProductWishList(int ID, int quantity, float unitPrice)
			throws ErrorConnectionException, UnknownIDProductException {
		return new JDBCProductWishList(ID, quantity, unitPrice);
	}

}
