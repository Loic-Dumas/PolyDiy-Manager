package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import common.JDBConnection;
import common.excpetion.ErrorConnectionException;
import common.excpetion.SessionErrorException;
//TODO add Javadoc
/**
* 
* 
* @author Pierre Casati
* @version 1.0
* @since 2016-03-03
*/
public class SessionGenerator {
	public String generateSession(int ID) throws SessionErrorException, ErrorConnectionException {
		JDBConnection connection = JDBConnection.getInstance();
		String token = "";
		try {
			String query = "SELECT * FROM Session WHERE id='" + ID + "';";
			Statement state = connection.getStatement();
			ResultSet result = state.executeQuery(query);
			if(!result.next()) {
				do {
					result.close();
					token = UUID.randomUUID().toString();
					query = "SELECT * FROM Session WHERE Token='" + token + "';";
					result = state.executeQuery(query);
				} while(result.next());
				query = "INSERT INTO Session VALUES('" + token + "', '" + ID + "');";
				state.executeUpdate(query);
				result.close();
				state.close();
			} else {
				throw new SessionErrorException(ID);
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
		return token;
	}
}
