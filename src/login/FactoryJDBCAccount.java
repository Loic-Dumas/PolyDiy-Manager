package login;

public class FactoryJDBCAccount extends FactoryAccount {

	@Override
	public Account build(String login) {
		return new JDBCAccount(login);
	}

}
