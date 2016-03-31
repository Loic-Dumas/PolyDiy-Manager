package logic.account;

import persistent.abstractclass.Account;
import persistent.factory.SessionFactory;
import persistent.factory.jdbcFactory.JDBCSessionFactory;

/**
 * 
 * @author Faustine
 * @version 1.0
 * @since 2016-31-03
 * 
 */

public class ModifyAccountHandler {
	private Account account =null; 

	/** to update an account with its ID, login, firstname
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
	public void update(int accountID, String login, String firstName, String lastName, String road, String postalCode, String city) throws Exception{
		SessionFactory factory = new JDBCSessionFactory();
		account = factory.buildAccountWithID(accountID);
		if(login != ""){
			this.account.setLogin(login);
		}
		if(firstName != ""){
			this.account.setFirstName(firstName);
		}
		if(lastName != ""){
			this.account.setLastName(lastName);
		}
		if(road != ""){
			this.account.setRoad(road);
		}
		if(city != ""){
			this.account.setCity(city);
		}
		if(postalCode != ""){
			this.account.setPostalCode(postalCode);
		}
		if(account != null){
			this.account.update();
		}
		
	}

	
	/**
	 * to get the login of an account with its ID 
	 * @param ID
	 * @return the login of the account
	 * @throws Exception
	 */
	public String getLogin(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String loginBD = account.getLogin();
	return loginBD;
	}
	
	/**
	 * to get the lastName of an account with its ID 
	 * @param ID
	 * @return the last name of the account
	 * @throws Exception
	 */
	public String getLastName(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String lastNameBD = account.getLastName();
	return lastNameBD;
	}
	
	/**
	 * to get the firstName of an account with its ID 
	 * @param ID
	 * @return the first name of the account
	 * @throws Exception
	 */
	public String getFirstName(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String firstNameBD = account.getFirstName();
	return firstNameBD;
	}
	
	/**
	 * to get the address road of an account with its ID 
	 * @param ID
	 * @return the address road of the account
	 * @throws Exception
	 */
	public String getAddressRoad(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressRoadBD = account.getAddressRoad();
	return addressRoadBD;
	}
	
	/**
	 * to get the address city of an account with its ID 
	 * @param ID
	 * @return the address city of the account
	 * @throws Exception
	 */
	public String getAddressCity(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressCityBD = account.getAddressCity();
	return addressCityBD;
	}
	
	/**
	 * to get the address postal of an account with its ID 
	 * @param ID
	 * @return the address postal code of the account
	 * @throws Exception
	 */
	public String getAddressPostal(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressPostalBD = account.getAddressPostal();
	return addressPostalBD;
	}
	
}
