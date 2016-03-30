package logic;

import java.util.Arrays;

import common.factory.SessionFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Session;

public class SessionHandler {
	public Session login(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.generateToken();
		session.insert();
		session.loadFromKeys(Arrays.asList("id"), Arrays.asList(Integer.toString((session.getID()))));
		return session;
	}
	
	public void logout(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.delete();;
	}
}