package common.factory;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import persistent.Seller;

public abstract class ProfilFactory {
	
	public abstract Seller  buildSeller(int ID) throws ErrorConnectionException, UnknownIDSellerException;
}
