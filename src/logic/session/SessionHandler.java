package logic.session;

import common.exception.ErrorConnectionException;
import common.exception.SessionErrorException;
import common.factory.JDBCSessionFactory;
import common.factory.SessionFactory;
import persistent.Session;

public class SessionHandler {
	public String login(int ID) throws ErrorConnectionException, SessionErrorException {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithID(ID);
		session.login();
		return session.getToken();
	}
	
	public void logout(String token) throws ErrorConnectionException {
		SessionFactory factory = new JDBCSessionFactory();
		Session session = factory.buildSessionWithToken(token);
		session.logout();
	}
}
