package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ErrorConnectionException;
import common.JDBConnection;
import common.UnknowLoginException;

public class JDBCAccount  extends Account {
	public JDBCAccount(String login) throws ErrorConnectionException, UnknowLoginException {
		super(login);
		// aller chercher l'identifiant dans a BD etc. 
		String query = "SELECT * FROM account WHERE login = " + login + ";";
		JDBConnection connection = JDBConnection.getInstance();
		Statement statement;
		try {
			statement = connection.getStatement();
			ResultSet result = statement.executeQuery(query);
			if (result.next()) {
				this.password = result.getString("password");
				this.ID = result.getInt("id");
				
			} else {
				throw new UnknowLoginException(login);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
