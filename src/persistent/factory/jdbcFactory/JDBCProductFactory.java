package persistent.factory.jdbcFactory;
/**
 * @author nassim vachor, loic
 * @version 1.0
 * @since 2016-03-21
 */
import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import persistent.abstractclass.Product;
import persistent.abstractclass.list.ProductWishList;
import persistent.factory.ProductFactory;
import persistent.jdbc.JDBCProduct;
import persistent.jdbc.list.JDBCProductWishList;

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
	public Product buildProduct( String name, String description, float unitPrice, int stockQuantity,
			int IDSeller, int IDCategory, String categoryName) {
		return new JDBCProduct( name,  description,  unitPrice,  stockQuantity,
				 IDSeller,  IDCategory,  categoryName);
	}
	

	@Override
	public ProductWishList buildProductWishList(int ID, int IDWishList, int quantity, float unitPrice)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		return new JDBCProductWishList(ID, IDWishList, quantity, unitPrice);
	}
}
