package common.factory.jdbcFactory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import persistent.jdbc.list.JDBCCart;
import persistent.jdbc.list.JDBCSetWishList;
import persistent.jdbc.list.JDBCWishList;
import persistent.list.Cart;
import persistent.list.SetWishList;
import persistent.list.WishList;

public class JDBCListFactory extends ListFactory{

	@Override
	public WishList buildWishList(int IDWishList) throws ErrorConnectionException, AlertDriver {
		return new JDBCWishList(IDWishList);
	}

	@Override
	public SetWishList buildSetWishList(int IDUser) throws  AlertDriver, ErrorConnectionException {
		return new JDBCSetWishList(IDUser);
	}

	@Override
	public Cart buildCart(int IDWishList) throws ErrorConnectionException, AlertDriver {
		return new JDBCCart(IDWishList);
	}

}
