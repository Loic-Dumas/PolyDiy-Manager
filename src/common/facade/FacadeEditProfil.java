package common.facade;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */
import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import logic.UpdateProfilHandler;

public class FacadeEditProfil {
	int IDaccount = -1;
	UpdateProfilHandler handler = new UpdateProfilHandler();
	public FacadeEditProfil (int IDaccount){
		this.IDaccount = IDaccount;
	}
	
public void createSeller(int ID, String nameShop, String description, String siret, String website) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {
		
		this.handler.createSeller(IDaccount, nameShop, description, siret, website);
		
	}
	
	public String getNameShop() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver{
		
		this.handler.createSellerId(IDaccount);
		return this.handler.getNameShop();		}
	public void SetNameShop(String name) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
				this.handler.createSellerId(IDaccount);
	             this.handler.setNameShop(name);     
	}
	public String getSiret() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.createSellerId(IDaccount);
		return this.handler.getSiret();
		}	
	public void SetSiert(String siret) throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		this.handler.createSellerId(IDaccount);
		this.handler.setSiert(siret);
	}
	public String getWebsite() throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.createSellerId(IDaccount);
		return this.handler.getWebsite();
		}
		
	public void setWebsite(String site) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.createSellerId(IDaccount);
		this.handler.settWebsite(site);
		}
	public String getDescription () throws ErrorConnectionException, UnknownIDSellerException, AlertDriver{
		this.handler.createSellerId(IDaccount);
		return this.handler.getDescription();
	}
	public void setDescription(String desc) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		this.handler.createSellerId(IDaccount);    
		this.handler.setDescription(desc);
		}
	public void Validate() throws Exception{
		
		this.handler.Validate();
	}
	
}
