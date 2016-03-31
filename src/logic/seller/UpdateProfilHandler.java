package logic.seller;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import persistent.abstractclass.Seller;
import persistent.factory.SellerProfilFactory;
import persistent.factory.jdbcFactory.JDBCSellerProfilFactory;

public class UpdateProfilHandler {

	private Seller seller = null;	

	SellerProfilFactory ProfilFactory = new JDBCSellerProfilFactory();
	
	/**
	 * This method create a new seller, it call buildSeller which is in JDBCSellerProfilFactory .
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param ID( which is idaccount) - nameShop - description - siret-website
	 */
	public void createSeller(int ID, String nameShop, String description, String siret, String website) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {

		this.seller = ProfilFactory.buildSeller( ID, nameShop, description, siret, website);
	}

	/**
	 * This method load a seller from DB, it call buildSeller(ID) .
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param ID
	 */
	
	public void getSellerWithId(int ID) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {

		this.seller = ProfilFactory.buildSeller(ID);
	}

	/** 
	 * This method get the nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return nameShop
	 */
	public String getNameShop( ) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {

		return  this.seller.getNameShop();
	}

	/**
	 * This method set the nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param name
	 */

	public void setNameShop(String name) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{

		this.seller.setNameShop(name);
	}
	/**
	 * This method get siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return siret
	 */

	public String getSiret( ) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		return this.seller.getSiret();
	} 



	/**
	 * This method set  siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param siret
	 */

	public void setSiert(String siret) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{

		this.seller.setSiret(siret);
	}


	/**
	 * This method get website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Website
	 */

	public String getWebsite( ) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		return this.seller.getWebsite();
	}

	/**
	 * This method set website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param site
	 *
	 */


	public void settWebsite( String site) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {

		this.seller.setWebsite(site);
	}
	/**
	 * This method get Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Description
	 */
	public String getDescription () throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		return this.seller.getDescription();
	}
	/**
	 * This method set Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	public void setDescription(String desc) throws UnknownIDSellerException,ErrorConnectionException, AlertDriver {
		this.seller.setDescription(desc);
	}

	/**
	 * This method validate the modification of seller informations
	 * it calls update method which is in JDBCSeller
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	public void Validate() throws Exception{
		if (seller != null){
			this.seller.update();
		}
	}
}
