package common.factory;

import common.exception.ErrorConnectionException;
import persistent.Cart;
import persistent.WishList;

/**
 * Builds wishList and cart.
 * 
 * @author loicd_000
 * @since 2016-03-21
 * @version 1.0
 */
public abstract class ListFactory {
	public abstract WishList buildWishList(int ID) throws ErrorConnectionException;
	public abstract Cart buildCart(int ID) throws ErrorConnectionException;
}
