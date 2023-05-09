package com.finolitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import com.finolitech.entity.Gender;
import com.finolitech.entity.Status;
import com.finolitech.entity.User;
import com.finolitech.utility.DB_Utility;

public class UserRepository {
	
	public String registerUser(User user) {
		
		String message= "Not Registered..";
		 
		try (Connection connection = DB_Utility.provideJDBCConnection()){
		
			PreparedStatement ps= connection.prepareStatement("insert into user_info(name, email, gender, status, timestamp) values(?,?,?,?,?)");

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setObject(3, user.getGender());
			ps.setObject(4, user.getStatus());
			ps.setObject(5, ZonedDateTime.now());
			
			// This will insert the data into the "user_info" table and return the number of rows affected.
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0)
				message ="User Registered Sucessfully..!";
			
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		
		return message;
	
	}
	
	public User updateUser(Integer id, User user) {
		User updatedUser = null;
		
		try (Connection connection = DB_Utility.provideJDBCConnection()){
		PreparedStatement ps= connection.prepareStatement("update user_info SET name=?, email=?, gender=?, status=?, timestamp=? WHERE id=?");
		ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getGender().toString());
        ps.setString(4, user.getStatus().toString());
        ps.setObject(5, ZonedDateTime.now());
        ps.setInt(6, id);
        
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) 
            updatedUser = new User(id, user.getName(), user.getEmail(), user.getGender(), user.getStatus(), ZonedDateTime.now());
        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
		return updatedUser;
	}
	
	public List<User> getAllUsers(){
		
		List<User> users = new ArrayList<>();
		
		try (Connection conn= DB_Utility.provideJDBCConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from user_info");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            Gender gender = Gender.valueOf(rs.getString("gender"));
	            Status status = Status.valueOf(rs.getString("status"));
	            ZonedDateTime timestamp = rs.getObject("timestamp", ZonedDateTime.class);
	            
	            User user = new User(id, name, email, gender, status, timestamp);
				
	            users.add(user);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return users;
		
	}

}
