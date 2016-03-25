package common.facade;

import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import logic.SessionHandler;
import logic.UpdateProfilHandler;
import persistent.Session;

public class FacadeEditProfil {
	Session session;
	UpdateProfilHandler handler = new UpdateProfilHandler();
	public FacadeEditProfil (Session s){
		this.session = s;
	}
	public String getNameShop() throws UnknownIDSellerException, ErrorConnectionException{
		
		return handler.getNameShop(session.getID());
		}
	public void SetNameShop(String name) throws ErrorConnectionException, UnknownIDSellerException{
		
	                  handler.SetNameShop(name, session.getID());     
	}
	public String getSiret() throws UnknownIDSellerException, ErrorConnectionException {
		
		return handler.getSiret(session.getID());
		}	
	public void SetSiert(String siret) throws ErrorConnectionException, UnknownIDSellerException{
		
		handler.SetSiert(siret, session.getID());
	}
	public String getWebsite() throws UnknownIDSellerException, ErrorConnectionException {
		
		return handler.getWebsite(session.getID());
		}
		
	public void setWebsite(String site) throws UnknownIDSellerException, ErrorConnectionException {
		
		handler.settWebsite(session.getID(), site);
		}
	public String getDescription () throws ErrorConnectionException, UnknownIDSellerException{
		return handler.getDescription(session.getID());
	}
	public void setDescription(String desc) throws UnknownIDSellerException, ErrorConnectionException {
		    handler.setDescription(session.getID(), desc);
		}
	
	
}
