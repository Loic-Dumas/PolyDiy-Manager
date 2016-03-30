package common.facade;

import logic.ModifyAccountHandler;
import persistent.Session;


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
	/*public void updateAccount(int accountID, String updateLogin, String updatefirstName, String updatelastName) throws Exception {
		ModifyAccountHandler handler = new ModifyAccountHandler();
		handler.update(accountID, updateLogin, updatefirstName, updatelastName);
	}*/

	public String getLogin(Session session) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String login = handler.getLogin(session); // récupérer le login : cf modifyAccountHandler
		return login;
	}
	
	public String getFirstName(Session session) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String firstName = handler.getFirstName(session); // récupérer le first name : cf modifyAccountHandler
		return firstName;
	}
	
	public String getLastName(Session session) throws Exception{
		ModifyAccountHandler handler = new ModifyAccountHandler();
		String lastName = handler.getLastName(session); // récupérer le last name : cf modifyAccountHandler
		return lastName;
	}
	
	
}
