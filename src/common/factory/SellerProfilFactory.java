package common.factory;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import persistent.Seller;
import persistent.User;

public abstract class SellerProfilFactory {
	
	public abstract Seller buildSeller(int ID) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver ;
	public abstract Seller buildSeller(int ID, String nameShop, String description, String siret, String webSite) throws ErrorConnectionException, AlertDriver ;
	public abstract Seller buildSellerEmpty() throws ErrorConnectionException, AlertDriver;

	public abstract User buildUserEmpty() throws ErrorConnectionException, AlertDriver; 
}
   