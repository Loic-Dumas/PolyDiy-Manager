package login;

public class JDBCAccount  extends Account {
	public JDBCAccount(String login){
		this.login = login;
		// aller chercher l'identifiant dans a BD etc. 
	}
}
