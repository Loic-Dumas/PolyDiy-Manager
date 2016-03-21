package common.factory.jdbcFactory;

import common.exception.ErrorConnectionException;
import common.factory.SessionFactory;
import persistent.Account;
import persistent.Session;
import persistent.jdbc.JDBCAccount;
import persistent.jdbc.JDBCSession;

public class JDBCSessionFactory extends SessionFactory {

	@Override
	public Account buildAccount(String loginIn) throws Exception {
		return new JDBCAccount(loginIn);
	}

	@Override
	public Session buildSession(String tokenIn, int IDin) throws ErrorConnectionException {
		return new JDBCSession(tokenIn, IDin);
	}

	@Override
	public Session buildSessionWithID(int IDin) throws ErrorConnectionException {
		return new JDBCSession(IDin);
	}

	@Override
	public Session buildSessionWithToken(String tokenIn) throws ErrorConnectionException {
		return new JDBCSession(tokenIn);
	}
}
