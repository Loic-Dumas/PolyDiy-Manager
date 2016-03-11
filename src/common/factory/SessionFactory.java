package common.factory;

import common.exception.ErrorConnectionException;
import persistent.Account;
import persistent.Session;

public abstract class SessionFactory {
	public abstract Account buildAccount(String loginIn) throws Exception;
	
	public abstract Session buildSession(String tokenIn, int IDin);
	public abstract Session buildSessionWithID(int IDin) throws ErrorConnectionException;
	public abstract Session buildSessionWithToken(String tokenIn);
}
