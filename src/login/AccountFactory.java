package login;

import common.ErrorConnectionException;
import common.UnknownLoginException;

public abstract class AccountFactory {
	public abstract Account build(String login) throws UnknownLoginException, ErrorConnectionException;
}
