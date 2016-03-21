package persistent;
/**
 * A seller contains ID, nameShop, description, siret and website.
 * A seller is created with his ID.
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

public class Seller {
	protected int ID;
	protected String nameShop;
	protected String description;
	protected String  siret;
	protected String website;
	public Seller (int ID) {
		this.ID = ID;
	}
	public String getNameShop() {
		return nameShop;
	}
	public void setName(String nameShop) {
		this.nameShop = nameShop;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
