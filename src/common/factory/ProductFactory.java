package common.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import persistent.Product;
import persistent.list.ProductWishList;

public abstract class ProductFactory {
	public abstract Product buildProduct(int ID) throws ErrorConnectionException, UnknownIDProductException, AlertDriver;
	
	public abstract ProductWishList buildProductWishList(int ID, int IDWishList, int quantity, float unitPrices) 
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver;
}
