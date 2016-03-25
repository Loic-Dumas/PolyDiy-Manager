package logic;
/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import common.factory.ProfilFactory;
import common.factory.jdbcFactory.JDBCProfilFactory;

public class UpdateProfilHandler {
		
	ProfilFactory ProfilFactory = new JDBCProfilFactory();
	
	public String getNameShop(int ID) throws UnknownIDSellerException, ErrorConnectionException {
		
		return ProfilFactory.buildSeller(ID).getNameShop();
		}
	public void SetNameShop(String name, int ID) throws ErrorConnectionException, UnknownIDSellerException{
	
		ProfilFactory.buildSeller(ID).setName(name);
	}
	public String getSiret(int ID) throws UnknownIDSellerException, ErrorConnectionException {
		
		return ProfilFactory.buildSeller(ID).getSiret();
		}	
	public void SetSiert(String siret, int ID) throws ErrorConnectionException, UnknownIDSellerException{
		
		ProfilFactory.buildSeller(ID).setSiret(siret);
	}
	public String getWebsite(int ID) throws UnknownIDSellerException, ErrorConnectionException {
		
		return ProfilFactory.buildSeller(ID).getWebsite();
		}
	public void settWebsite(int ID, String site) throws UnknownIDSellerException, ErrorConnectionException {
		
		ProfilFactory.buildSeller(ID).setWebsite(site);
		}
	public String getDescription (int ID) throws ErrorConnectionException, UnknownIDSellerException{
		return ProfilFactory.buildSeller(ID).getDescription();
	}
	public void setDescription(int ID, String desc) throws UnknownIDSellerException, ErrorConnectionException {
		ProfilFactory.buildSeller(ID).setDescription(desc);
		}
	
}
