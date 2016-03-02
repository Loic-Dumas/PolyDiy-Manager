package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
	private Connection connection;
	static JDBConnection instance;
	
	private JDBConnection(String user, String password, String URL) throws Exception {
		Class.forName("org.postgresql.Driver");
		this.connection = DriverManager.getConnection(URL , user, password);
	}
	
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
	
<<<<<<< HEAD
	public Statement getStatement() throws SQLException {
		return this.connection.createStatement();
	}
	
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}
=======
	public Statement getStatement () throws SQLException {
		return this.connection.createStatement();
	}
	
	public PreparedStatement getPreparedStatement (String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}
	
>>>>>>> 19d096cf176426501c504bd725533a34c2c0b4e0
}
