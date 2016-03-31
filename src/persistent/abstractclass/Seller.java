package persistent.abstractclass;

/**
 * A seller contains ID, nameShop, description, siret and website.
 * A seller is created with his ID.
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

public abstract class Seller implements InterfaceModel{
	protected int ID = -1;
	protected int IDaccount = -1;
	protected String nameShop = "";
	protected String description = "";
	protected String siret = "";
	protected String website = "";
	/**
	 * This is Constructor of Seller.
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	public Seller(){
		
	}
	
	/**
	 * This is Constructor of Seller with id.
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	public Seller (int ID) {
		this.ID = ID;
	}
	/**
	 * This is a getter of the IDseller.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return IDseller
	 */
	public int getId(){
		return ID;
	}
	/**
	 * The Setter of IDseller.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	public void setId(int id){
		this.ID = id;
	}
	
	/**
	 * This a getter of  id_account.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return IDaccount
	 */
	public int getIDaccount() {
		return this.IDaccount;
	}
	/**
	 * This a setter of  id_account.
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	
	public void setIDaccount(int IDaccount) {
		this.IDaccount = IDaccount;
	}
	/** 
	 * This a getter of  nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return nameShop
	 */
	
	public String getNameShop() {
		return nameShop;
	}
	/**
	 * This a setter of  nameShop.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}
	/**
	 * This a getter of  Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * This a setter of  Description.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * This a getter of  siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return siret
	 */
	public String getSiret() {
		return siret;
	}
	/**
	 * This a setter of  siret.
	 * @author nassim vachor
	 * @since 2016-03-21
	 */ 
	public void setSiret(String siret) {
		this.siret = siret;
	}
	/**
	 * This a getter of  website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * This a setter of  website.
	 * @author nassim vachor
	 * @since 2016-03-21
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	
	
}
