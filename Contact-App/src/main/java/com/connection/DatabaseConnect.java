package com.connection;

import java.sql.*;

public class DatabaseConnect {

	private static Connection con;
	
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ContactApp", "sk768");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
