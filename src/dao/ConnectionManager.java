package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionManager {

	private static String serverName = "localhost";
	private static int port = 3306;
	private static String databaseName = "conferenceproj";
	private static String user = "root";
	private static String password = "";

	public static Connection getConnection() throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName(serverName);
		dataSource.setPort(port);
		dataSource.setDatabaseName(databaseName);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		Connection conn = (Connection) dataSource.getConnection();
		return conn;
	}

}
