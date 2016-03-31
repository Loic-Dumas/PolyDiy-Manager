package persistent.factory;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import persistent.abstractclass.Product;
import persistent.abstractclass.list.ProductWishList;

public abstract class ProductFactory {
	public abstract Product buildProduct(int ID)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver;
	public abstract Product buildProduct(int ID, int IDSeller)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver;
	public abstract Product buildProduct( int idP, String name, String description, float unitPrice,
			int stockQuantity, int IDSeller, int IDCategory, String categoryName);

	public abstract ProductWishList buildProductWishList(int ID, int IDWishList, int quantity, float unitPrice)
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver;
}
