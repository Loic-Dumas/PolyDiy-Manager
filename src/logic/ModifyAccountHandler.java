package logic;

import common.factory.SessionFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Account;

public class ModifyAccountHandler {
	private Account account =null; 

	public void update(int accountID, String login, String firstName, String lastName, String road, String postalCode, String city) throws Exception{
		SessionFactory factory = new JDBCSessionFactory();
		account = factory.buildAccountWithID(accountID);
		if(login != ""){
			System.out.println("on est dans le setLogin");
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
	 * @param ID
	 * @return 
	 * @throws Exception
	 */
	public String getLogin(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String loginBD = account.getLogin();
	return loginBD;
	}
	
	public String getLastName(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String lastNameBD = account.getLastName();
	return lastNameBD;
	}
	
	public String getFirstName(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String firstNameBD = account.getFirstName();
	return firstNameBD;
	}
	
	public String getAddressRoad(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressRoadBD = account.getAddressRoad();
	return addressRoadBD;
	}
	
	public String getAddressCity(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressCityBD = account.getAddressCity();
	return addressCityBD;
	}
	
	public String getAddressPostal(int ID) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccountWithID(ID);
		String addressPostalBD = account.getAddressPostal();
	return addressPostalBD;
	}
	
}
