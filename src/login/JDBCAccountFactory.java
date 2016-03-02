package login;

import common.ErrorConnectionException;
import common.UnknownLoginException;

public class JDBCAccountFactory extends AccountFactory {
	public JDBCAccountFactory() {
		
	}

	@Override
	public Account build(String login) throws UnknownLoginException, ErrorConnectionException {
		return new JDBCAccount(login);
	}

}
