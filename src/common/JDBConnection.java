package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
	//postgres login
	private Connection connection;
	static JDBConnection instance;
	
	private JDBConnection(String user, String password, String URL) throws Exception {
		Class.forName("org.postgresql.Driver");
		this.connection = DriverManager.getConnection(URL , user, password);
	}
	
	public static JDBConnection getInstance() {
		if (JDBConnection.instance == null) {
			try {
				JDBConnection.instance = new JDBConnection("postgres", "postgres", "jdbc:postgresql://localhost:5432/PolyDIYManager");
			} catch (SQLException e) {
				System.err.println("Connection error. (add a t to posTgre)");
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("Driver not found.");
				e.printStackTrace();
			}
		}
		return JDBConnection.instance;
	}
	
}
