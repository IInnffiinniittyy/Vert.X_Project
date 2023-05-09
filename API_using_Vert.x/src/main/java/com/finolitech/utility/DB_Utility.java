package com.finolitech.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class is to establish a database connection to the specified MySQL database...

public class DB_Utility {

public static Connection provideJDBCConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/finolitech";
		
		try {
			connection =  DriverManager.getConnection(url, "root", "tanu");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
