package login;

public class JDBCAccountFactory extends AccountFactory {

	@Override
	public Account build(String login) {
		return new JDBCAccount(login);
	}

}
