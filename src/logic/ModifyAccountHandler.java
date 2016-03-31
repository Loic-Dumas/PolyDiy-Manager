package logic;

import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Account;

public class ModifyAccountHandler {

/*	public void update(int accountID, String login, String firstName, String lastName) throws Exception{
		SessionFactory factory = new JDBCSessionFactory();
		Account account = factory.buildAccount(login);
		if(account.getLogin()!=null){
			//on modifie le loggin
		}
		if(account.getfirstName()!=null){
			//on modifie le firstName
		}
		if(account.getlastName()!=null){
			//on modifie le lastName
		}
	} */
	

	
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
