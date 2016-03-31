package logic.facade;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */
import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import logic.seller.UpdateProfilHandler;

public class FacadeEditProfil {
	int IDaccount = -1;
	UpdateProfilHandler handler = new UpdateProfilHandler();
	/**
	 * The constructor of FacadeEditProfil
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param IDaccount
	 */
	public FacadeEditProfil (int IDaccount){
		this.IDaccount = IDaccount;
	}

	/**
	 * This method create a new seller, it call buildSeller which is in JDBCSellerProfilFactory .
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param ID( which is idaccount) - nameShop - description - siret-website
	 */
	
	public void createSeller(int ID, String nameShop, String description, String siret, String website) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {

		this.handler.createSeller(IDaccount, nameShop, description, siret, website);

	}
	 
		
		
	/** 
	 * This method get the nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return nameShop
	 */
	public String getNameShop() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver{

		this.handler.getSellerWithId(IDaccount);
		return this.handler.getNameShop();		}
	/**
	 * This method set the nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param name
	 */
	public void SetNameShop(String name) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		this.handler.getSellerWithId(IDaccount);
		this.handler.setNameShop(name);     
	}
	
	
	/**
	 * This method get siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return siret
	 */
	public String getSiret() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.getSellerWithId(IDaccount);
		return this.handler.getSiret();
	}	
	/**
	 * This method set  siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param siret
	 */
	public void SetSiert(String siret) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		this.handler.getSellerWithId(IDaccount);
		this.handler.setSiert(siret);
	}
	/**
	 * This method get website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Website
	 */
	public String getWebsite() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.getSellerWithId(IDaccount);
		return this.handler.getWebsite();
	}

	/**
	 * This method set website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param site
	 *
	 */
	
	public void setWebsite(String site) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.getSellerWithId(IDaccount);
		this.handler.settWebsite(site);
	}
	/**
	 * This method get Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Description
	 */
	public String getDescription () throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		this.handler.getSellerWithId(IDaccount);
		return this.handler.getDescription();
	}
	/**
	 * This method set Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	public void setDescription(String desc) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.getSellerWithId(IDaccount);    
		this.handler.setDescription(desc);
	}
	/**
	 * This method validate the modification of seller informations
	 * it calls update method which is in JDBCSeller
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	public void Validate() throws Exception{

		this.handler.Validate();
	}

}
