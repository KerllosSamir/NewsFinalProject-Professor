package wap.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	// JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/wapnews";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "123456";
	Connection conn = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		//Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected database successfully...");
		return conn;
	}
}
