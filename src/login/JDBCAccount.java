package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ErrorConnectionException;
import common.JDBConnection;
<<<<<<< HEAD
import common.UnknownLoginException;

public class JDBCAccount  extends Account {
	public JDBCAccount(String login) throws UnknownLoginException, ErrorConnectionException{
		super(login);
		
		JDBConnection connection = JDBConnection.getInstance();
		String query = "SELECT * FROM Account WHERE Login='" + login + "';";
		Statement state;
		try {
			state = connection.getStatement();
			ResultSet result = state.executeQuery(query);
			if(result.next()) {
				this.ID = result.getInt("Id");
				this.password = result.getString("Password");
			} else {
				throw new UnknownLoginException(login);
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
=======
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
		
>>>>>>> 19d096cf176426501c504bd725533a34c2c0b4e0
	}
}
