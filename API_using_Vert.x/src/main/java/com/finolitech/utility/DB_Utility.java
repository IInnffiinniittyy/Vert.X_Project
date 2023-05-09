package com.finolitech.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class is to establish a database connection to the specified MySQL database...

public class DB_Utility {

// static method named "provideConnection" which returns a connection object of the MySQL database.	
public static Connection provideJDBCConnection() {
		
		Connection connection = null;
		
//      the code tries to load the "com.mysql.cj.jdbc.Driver" driver class using the Class.forName method.
//		If the class is not found, the catch block prints the stack trace of the exception.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//      database URL, including the name of the database to which a connection needs to be established.		
		String url = "jdbc:mysql://localhost:3306/finolitech";
		
//       DriverManager.getConnection() method is called to establish a connection to the DB.		
		try {
			connection =  DriverManager.getConnection(url, "root", "tanu");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
