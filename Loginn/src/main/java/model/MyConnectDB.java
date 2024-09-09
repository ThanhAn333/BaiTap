package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnectDB {
	private final String serverName = "localhost";
	private final String dbName = "Login";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123";

	public Connection connect() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public  void thucThiSQL(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public ResultSet chonDuLieu(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}
	

	public PreparedStatement dungStament(String sql) throws SQLException, Exception{
		return connect().prepareStatement(sql);
	}
	
public static void main(String[] args) throws Exception {
	System.out.println(new MyConnectDB().connect());
}
}
