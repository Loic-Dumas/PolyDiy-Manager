package logic.facade;

import logic.account.ModifyAccountHandler;


/**
 * This class contains all functions to modify account
 * 
 * @author Faustine GEOFFRAY
 * @version 1.0
 * @since 2016-29-03
 */

public class FacadeModifyAccount {
	public FacadeModifyAccount(){	
	}
	
	
	/**
	 * to update an account with its ID, login, firstname
	 * lasname, and the complete address (road, city and postal code)
	 * @param accountID 
	 * @param updateLogin - the new login
	 * @param updatefirstName - the new first name
	 * @param updatelastName - the new last name
	 * @param road - the new road
	 * @param postalCode - the new postal code
	 * @param city - the new city
	 * @throws Exception
	 */
	public void updateAccount(int accountID, String updateLogin, String updatefirstName, String updatelastName, String road, String postalCode, String city) throws Exception {
		ModifyAccountHandler handler = new ModifyAccountHandler();
		handler.update(accountID, updateLogin, updatefirstName, updatelastName, road, postalCode,city);
	}

	/**
	 * to get the login of an account with its ID
	 * @param ID
	 * @return the login of the account
	 * @throws Exception
	 */
	public String getLogin(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String login = handler.getLogin(ID); // récupérer le login : cf modifyAccountHandler
		return login;
	}
	
	/**
	 * to get the firstName of an account with its ID 
	 * @param ID
	 * @return the firstName of the account
	 * @throws Exception
	 */
	public String getFirstName(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String firstName = handler.getFirstName(ID); // récupérer le first name : cf modifyAccountHandler
		return firstName;
	}
	
	/**
	 * to get the lastName of an account with its ID
	 * @param ID
	 * @return the lastName of the account
	 * @throws Exception
	 */
	public String getLastName(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String lastName = handler.getLastName(ID); // récupérer le last name : cf modifyAccountHandler
		return lastName;
	}
	
	/**
	 * to get the address Road of an account with its ID
	 * @param ID
	 * @return the address road of the account
	 * @throws Exception
	 */
	public String getAddressRoad(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressRoad = handler.getAddressRoad(ID); //cf modifyAccountHandler
		return AddressRoad;
	}
	
	/**
	 * to get the address City of an account with its ID
	 * @param ID
	 * @return the address City of the account
	 * @throws Exception
	 */
	public String getAddressCity(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressCity = handler.getAddressCity(ID); //cf modifyAccountHandler
		return AddressCity;
	}
	
	/**
	 * to get the address postal code of an account with its ID
	 * @param ID
	 * @return the address postal code of the account
	 * @throws Exception
	 */
	public String getAddressPostal(int ID) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String AddressPostal = handler.getAddressPostal(ID); //cf modifyAccountHandler
		return AddressPostal;
	}
	
	
}
