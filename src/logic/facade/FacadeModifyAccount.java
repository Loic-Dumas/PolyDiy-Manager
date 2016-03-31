package logic.facade;

import logic.account.ModifyAccountHandler;


/**
 * This class contains all functions to modify account
 * 
 * @author Faustine GEOFFRAY
 * @version 1.0
 * @since 2016-21-03
 */

public class FacadeModifyAccount {
	public FacadeModifyAccount(){	
	}
	
	//fonction updateAccount
	public void updateAccount(int accountID, String updateLogin, String updatefirstName, String updatelastName, String road, String postalCode, String city) throws Exception {
		ModifyAccountHandler handler = new ModifyAccountHandler();
		handler.update(accountID, updateLogin, updatefirstName, updatelastName, road, postalCode,city);
	}

	public String getLogin(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String login = handler.getLogin(ID); // récupérer le login : cf modifyAccountHandler
		return login;
	}
	
	public String getFirstName(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String firstName = handler.getFirstName(ID); // récupérer le first name : cf modifyAccountHandler
		return firstName;
	}
	
	public String getLastName(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String lastName = handler.getLastName(ID); // récupérer le last name : cf modifyAccountHandler
		return lastName;
	}
	
	public String getAddressRoad(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressRoad = handler.getAddressRoad(ID); //cf modifyAccountHandler
		return AddressRoad;
	}
	
	public String getAddressCity(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressCity = handler.getAddressCity(ID); //cf modifyAccountHandler
		return AddressCity;
	}
	
	public String getAddressPostal(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressPostal = handler.getAddressPostal(ID); //cf modifyAccountHandler
		return AddressPostal;
	}
	
	
}
