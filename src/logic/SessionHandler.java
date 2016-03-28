package logic;

import common.factory.SessionFactory;
import common.factory.jdbcFactory.JDBCSessionFactory;
import persistent.Session;

public class SessionHandler {
	public Session login(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.generateToken();
		session.insert();
		return session;
	}
	
	public void logout(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.delete();;
	}
}