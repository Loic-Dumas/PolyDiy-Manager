package common.factory.jdbcFactory;
/**
 * @author nassim vachor, loic
 * @version 1.0
 * @since 2016-03-21
 */
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
	public  Product buildProduct(int ID, int IDSeller)throws ErrorConnectionException, UnknownIDProductException, AlertDriver{
	
		return new JDBCProduct (ID,IDSeller);
	
	}
	@Override
	public Product buildProduct(int idP, String name, String description, float unitPrice, int stockQuantity,
			int IDSeller, int IDCategory, String categoryName) {
		return new JDBCProduct( idP, name,  description,  unitPrice,  stockQuantity,
				 IDSeller,  IDCategory,  categoryName);
	}
	

	@Override
	public ProductWishList buildProductWishList(int ID, int IDWishList, int quantity, float unitPrice)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		return new JDBCProductWishList(ID, IDWishList, quantity, unitPrice);
	}
}
