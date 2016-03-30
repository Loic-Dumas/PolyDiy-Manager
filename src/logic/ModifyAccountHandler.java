package logic;

import common.factory.ModifyAccountFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Account;
import persistent.Session;

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
	 * @param session
	 * @return 
	 * @throws Exception
	 */
	public String getLogin(Session session) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		int ident = session.getID();
		Account account = factory.buildAccountWithID(ident);
		String loginBD = account.getLogin();
	return loginBD;
	}
	
	public String getLastName(Session session) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		int ident = session.getID();
		Account account = factory.buildAccountWithID(ident);
		String lastNameBD = account.getLastName();
	return lastNameBD;
	}
	
	public String getFirstName(Session session) throws Exception{
		JDBCSessionFactory factory = new JDBCSessionFactory();
		int ident = session.getID();
		Account account = factory.buildAccountWithID(ident);
		String firstNameBD = account.getFirstName();
	return firstNameBD;
	}
	
	
}
