package common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;

/**
 * This class crate a connection to the DB with JDBC.
 * This class use the pattern Singleton, because we cannot have more than one connection.
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 */ 
public class JDBConnection {
	//postgres login
	private Connection connection;
	static JDBConnection instance;
	
	private JDBConnection(String user, String password, String URL) throws ErrorConnectionException, AlertDriver {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			throw new AlertDriver();
		}
		try {
			this.connection = DriverManager.getConnection(URL , user, password);
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
	}
	
	/**
	 * getInstance() return a JDBConnection. 
	 * Use the pattern singleton to have only one connection.
	 * 
	 * @author loicd_000
	 * @version 1.0
	 * @since 2016-03-02
	 * @return JDBConnection
	 * @throws AlertDriver 
	 */
	public static JDBConnection getInstance() throws ErrorConnectionException, AlertDriver {
		if (JDBConnection.instance == null) {
			//JDBConnection.instance = new JDBConnection("postgres", "postgres", "jdbc:postgresql://localhost:5432/PolyDIYManager");
			JDBConnection.instance = new JDBConnection("pzloelfnjglnhj", "O3SE1wvyhy5mG0sHpuPnuQV-fA", "jdbc:postgresql://ec2-107-22-246-250.compute-1.amazonaws.com:5432/dcpgi43j5ks0gi?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
		}
		return JDBConnection.instance;
	}
	
	public Statement getStatement() throws SQLException {
		return this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
											   ResultSet.CONCUR_READ_ONLY,
											   ResultSet.HOLD_CURSORS_OVER_COMMIT);
	}
	
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}
}
