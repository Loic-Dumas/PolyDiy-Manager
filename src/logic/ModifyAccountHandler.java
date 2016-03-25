package logic;

import common.factory.JDBCAccountFactory;
import common.factory.JDBCSessionFactory;
import common.factory.ModifyAccountFactory;
import common.factory.SessionFactory;
import persistent.Account;

public class ModifyAccountHandler {

	public void update(int accountID, String login, String firstName, String lastName) throws Exception{
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
	}
	
	public String getLogin(int ID) throws Exception{
		ModifyAccountFactory factory = new JDBCAccountFactory();
		Account account = factory.buildAccountwithID(ID);
		String loginBD = account.getLogin();
	return loginBD;
	}
	
	public String getLastName(int ID) throws Exception{
		ModifyAccountFactory factory = new JDBCAccountFactory();
		Account account = factory.buildAccountwithID(ID);
		String lastNameBD = account.getlastName();
	return lastNameBD;
	}
	
	public String getFirstName(int ID) throws Exception{
		ModifyAccountFactory factory = new JDBCAccountFactory();
		Account account = factory.buildAccountwithID(ID);
		String firstNameBD = account.getfirstName();
	return firstNameBD;
	}
	
}
