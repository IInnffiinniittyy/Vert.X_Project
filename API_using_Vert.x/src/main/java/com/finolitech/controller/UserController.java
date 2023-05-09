package com.finolitech.controller;

import java.time.ZonedDateTime;
import java.util.List;
import com.finolitech.entity.Gender;
import com.finolitech.entity.Status;
import com.finolitech.entity.User;
import com.finolitech.service.UserService;
import com.finolitech.service.UserServiceImplementation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class UserController {
     
     private UserService userService = new UserServiceImplementation();
	    	
	 
	 
	public void getAllUsers(RoutingContext context) {
		 context.response().putHeader("content-type", "application/json");

		    List<User> users= userService.getAllUserDetails();
		   
		    

		    // Convert the user list to a JSON array
		    JsonArray jsonArray = new JsonArray();
		    for (User user: users) {
		        JsonObject jsonObject = new JsonObject();
		        
		        jsonObject.put("id", user.getId().toString());
		        jsonObject.put("name", user.getName());
		        jsonObject.put("email", user.getEmail());
		        jsonObject.put("gender", user.getGender().toString());
		        jsonObject.put("status", user.getStatus().toString());
		        jsonObject.put("timestamp", user.getTimestamp().toString());
		        
		        jsonArray.add(jsonObject);
		    }

		    // Set the response status and write the JSON array to the response body
		    context.response()
		            .setStatusCode(200) // OK
		            .end(jsonArray.encodePrettily()); // it will be part of response body
	}
	
	
	public void addUser(RoutingContext context) {
	    context.request().bodyHandler(bodyBuffer -> {
	        JsonObject requestJson = new JsonObject(bodyBuffer);

	        String name = requestJson.getString("name");
	        String email = requestJson.getString("email");
	        Gender gender = Gender.valueOf(requestJson.getString("gender"));
	        Status status = Status.valueOf(requestJson.getString("status"));

	        User newUser = new User(name, email, gender, status, ZonedDateTime.now());

	        userService.addUserDetails(newUser);

	        // Return a response indicating success or failure
	        JsonObject responseJson = new JsonObject();
	        responseJson.put("success", true);
	        context.response()
	                .putHeader("content-type", "application/json")
	                .setStatusCode(201) // Created
	                .end(responseJson.encodePrettily());
	    });
	}
	
	public void updateUser(RoutingContext context) {
	     context.request().bodyHandler(bodyBuffer -> {
	        JsonObject requestJson = new JsonObject(bodyBuffer);

	        Integer id = requestJson.getInteger("id");
	        String name = requestJson.getString("name");
	        String email = requestJson.getString("email");
	        Gender gender = Gender.valueOf(requestJson.getString("gender"));
	        Status status = Status.valueOf(requestJson.getString("status"));

	        User updatedUser = new User(id, name, email, gender, status, ZonedDateTime.now());

	        User result = userService.updateUserDetails(id, updatedUser);

	        if(result != null) {
	        // Return a response indicating success or failure
	        JsonObject responseJson = new JsonObject();
	        responseJson.put("success", true);
	        context.response()
	                .putHeader("content-type", "application/json")
	                .setStatusCode(200) // OK
	                .end(responseJson.encodePrettily());
	        }
	        else {
	        	 context.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(404) // Not Found
                .end();
	        }
	    });
	}
	
}
