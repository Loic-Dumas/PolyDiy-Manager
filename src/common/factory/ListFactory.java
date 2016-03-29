package common.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.list.Cart;
import persistent.list.SetWishList;
import persistent.list.WishList;

/**
 * Builds wishList and cart.
 * 
 * @author loicd_000
 * @since 2016-03-21
 * @version 1.0
 */
public abstract class ListFactory {
	public abstract WishList buildWishList(int IDWishList) throws ErrorConnectionException, AlertDriver;
	public abstract SetWishList buildSetWishList(int IDUser) throws ErrorConnectionException, AlertDriver ;
	public abstract Cart buildCart(int IDWishList) throws ErrorConnectionException, AlertDriver;
}
