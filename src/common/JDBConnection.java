package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class crate a connection to the DB with JDBC.
 * This class use the pattern Singleton, because we cannot have more than one connection.
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 */
public class JDBConnection {
	private Connection connection;
	static JDBConnection instance;
	
	private JDBConnection(String user, String password, String URL) throws Exception {
		Class.forName("org.postgresql.Driver");
		this.connection = DriverManager.getConnection(URL , user, password);
	}
	
	/**
	 * getInstance() return a JDBConnection. 
	 * Use the pattern singleton to have only one connection.
	 * 
	 * @author loicd_000
	 * @version 1.0
	 * @since 2016-03-02
	 * @return JDBConnection
	 */
	public static JDBConnection getInstance() throws ErrorConnectionException {
		if (JDBConnection.instance == null) {
			try {
				JDBConnection.instance = new JDBConnection("postgres", "postgres", "jdbc:postgresql://localhost:5432/PolyDIYManager");
			} catch (SQLException e) {
				throw new ErrorConnectionException();
			} catch (Exception e) {
				System.err.println("Driver not found.");
				e.printStackTrace();
			}
		}
		return JDBConnection.instance;
	}
	
	public Statement getStatement () throws SQLException {
		return this.connection.createStatement();
	}
	
	public PreparedStatement getPreparedStatement (String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}
	
}
