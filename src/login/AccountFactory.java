package login;

import common.ErrorConnectionException;
import common.UnknowLoginException;

public interface AccountFactory {
	public abstract Account build(String login) throws ErrorConnectionException, UnknowLoginException;
}
