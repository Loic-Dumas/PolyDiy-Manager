package common.factory.jdbcFactory;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import common.factory.ProfilFactory;
import persistent.Seller;
import persistent.jdbc.JDBCSeller;

public class JDBCProfilFactory extends ProfilFactory {
	@Override
	public Seller buildSeller(int ID) throws ErrorConnectionException, UnknownIDSellerException {
		return new JDBCSeller(ID);
	}

}
