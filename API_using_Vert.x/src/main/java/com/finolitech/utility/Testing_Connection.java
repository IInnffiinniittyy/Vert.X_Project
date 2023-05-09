package com.finolitech.utility;

import java.sql.Connection;
import java.sql.SQLException;


//  the program simply tests the database connection and confirms that it was established successfully.
public class Testing_Connection {

     public static void main(String[] args) throws SQLException{
		
		Connection test = DB_Utility.provideJDBCConnection();
		System.out.println("Connection Estabilished..! "+test);
		
	}
	
}
