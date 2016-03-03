package login;

/**
 * This Interface is an abstract factory who create Account.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
import common.ErrorConnectionException;
import common.UnknowLoginException;

public interface AccountFactory {
	public abstract Account build(String login) throws ErrorConnectionException, UnknowLoginException;
}
