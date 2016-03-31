package persistent.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.abstractclass.Account;
import persistent.abstractclass.Session;

public abstract class SessionFactory {
	public abstract Account buildAccount(String loginIn) throws Exception;
	public abstract Account buildAccount(String login, String password, String email, String firstName, String lastName) throws ErrorConnectionException, AlertDriver;
	
	public abstract Session buildSessionWithID(int IDin) throws ErrorConnectionException, AlertDriver;
	public abstract Account buildAccountWithID(int ID) throws Exception ;
}
