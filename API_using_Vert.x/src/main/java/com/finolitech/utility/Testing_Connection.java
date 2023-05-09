package com.finolitech.utility;

import java.sql.Connection;
import java.sql.SQLException;

public class Testing_Connection {

public static void main(String[] args) throws SQLException{
		
		Connection test = DB_Utility.provideJDBCConnection();
		System.out.println("Connection Estabilished..! "+test);
		
	}
	
}
