package login;

import common.excpetion.ErrorConnectionException;
import common.excpetion.UnknownLoginException;

public interface AccountFactory {
	public abstract Account build(String login) throws ErrorConnectionException, UnknownLoginException;
}
