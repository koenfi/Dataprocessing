package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	protected static Connection conn;
	protected static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	protected static final String DB_URL = "jdbc:oracle:thin:@//localhost:49161/xe";
	protected static final String DB_USER = "koenfi";
	protected static final String DB_PASS = "aagjes";
	
	public void closeConnection() throws SQLException {
		conn.close();
	}

}