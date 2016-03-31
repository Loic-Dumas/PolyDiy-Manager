package persistent.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.NoCartException;
import common.exception.wishListAlreadyExistException;
import persistent.abstractclass.SetProduct;
import persistent.abstractclass.list.Cart;
import persistent.abstractclass.list.SetInfoWishList;
import persistent.abstractclass.list.SetWishList;
import persistent.abstractclass.list.WishList;

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
	public abstract Cart buildCart(int IDWishList) throws ErrorConnectionException, AlertDriver, NoCartException;
	public abstract WishList buildWishList(int IDUser, String labelWishList) throws wishListAlreadyExistException ;
	public abstract SetProduct buildSetProduct(int IDSeller) throws ErrorConnectionException, AlertDriver;
	public abstract SetProduct buildSetProduct() throws ErrorConnectionException, AlertDriver;
	public abstract SetInfoWishList buildSetInfoWishList(int IDUser) throws AlertDriver, ErrorConnectionException;
}
