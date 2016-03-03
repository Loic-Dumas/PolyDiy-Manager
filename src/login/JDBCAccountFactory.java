package login;

import common.ErrorConnectionException;
import common.UnknowLoginException;

public class JDBCAccountFactory implements AccountFactory {

	public Account build(String login) throws ErrorConnectionException, UnknowLoginException {
		return new JDBCAccount(login);
	}

}
