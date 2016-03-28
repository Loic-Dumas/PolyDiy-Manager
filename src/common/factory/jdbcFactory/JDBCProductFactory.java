package common.factory.jdbcFactory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import persistent.Product;
import persistent.jdbc.JDBCProduct;
import persistent.jdbc.list.JDBCProductWishList;
import persistent.list.ProductWishList;

public class JDBCProductFactory extends ProductFactory{

	@Override
	public Product buildProduct(int ID) throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		return new JDBCProduct(ID);
	}

	@Override
	public ProductWishList buildProductWishList(int ID, int IDWishList, int quantity, float unitPrice)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		return new JDBCProductWishList(ID, IDWishList, quantity, unitPrice);
	}

}
