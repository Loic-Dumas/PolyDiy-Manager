package login;

import common.exception.ErrorConnectionException;
import common.exception.UnknownLoginException;

public interface AccountFactory {
	public abstract Account build(String login) throws ErrorConnectionException, UnknownLoginException;
}
