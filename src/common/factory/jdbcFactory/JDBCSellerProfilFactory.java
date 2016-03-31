package common.factory.jdbcFactory;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import common.factory.SellerProfilFactory;
import persistent.Seller;
import persistent.User;
import persistent.jdbc.JDBCSeller;
import persistent.jdbc.JDBCUser;

public class JDBCSellerProfilFactory extends SellerProfilFactory {
	@Override
	public Seller buildSeller(int ID) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver {
		return new JDBCSeller(ID);
	}
	@Override
	public  Seller buildSeller(int ID, String nameShop, String description, String siret, String website) throws ErrorConnectionException,
	AlertDriver{
		Seller seller = new JDBCSeller();
		seller.setId(ID);
		seller.setNameShop(nameShop);
		seller.setDescription(description);
		seller.setSiret(siret);
		seller.setWebsite(website);
		return seller;
		
	}
	@Override
	public Seller buildSellerEmpty() throws ErrorConnectionException, AlertDriver {
		return new JDBCSeller();
	}
	@Override
	public User buildUserEmpty() throws ErrorConnectionException, AlertDriver {
		return new JDBCUser();
	}

}
