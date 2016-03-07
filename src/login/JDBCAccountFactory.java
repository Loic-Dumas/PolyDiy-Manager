package login;

import common.excpetion.ErrorConnectionException;
import common.excpetion.UnknownLoginException;

/**
 * This class is a factory who implements the AccountFactory interface.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 *
 */
public class JDBCAccountFactory implements AccountFactory {

	public Account build(String login) throws ErrorConnectionException, UnknownLoginException {
		return new JDBCAccount(login);
	}

}
