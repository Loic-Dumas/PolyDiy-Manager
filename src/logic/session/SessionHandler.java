package logic.session;

import java.util.Arrays;

import persistent.abstractclass.Session;
import persistent.factory.SessionFactory;
import persistent.factory.jdbcFactory.JDBCSessionFactory;

public class SessionHandler {
	public Session login(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.generateToken();
		session.insert();
		session.loadFromKeys(Arrays.asList("id_account"), Arrays.asList(Integer.toString((session.getID()))));
		return session;
	}
	
	public void logout(int ID) throws Exception {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.delete();;
	}
}