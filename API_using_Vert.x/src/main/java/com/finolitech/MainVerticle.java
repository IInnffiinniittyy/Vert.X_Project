package com.finolitech;

import com.finolitech.controller.UserController;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

// 	 Java class that sets up a REST API server using the Vert.X library
public class MainVerticle {

	public static void main(String[] args) {
		
//		Creating VertX object-->the core of the Vert.X library -->responsible for managing the event loop, etc...
		Vertx vertx = Vertx.vertx();

//		Creating an HTTP server
		HttpServer server = vertx.createHttpServer();
		
//		Router is used to handle the HTTP request
		Router router = Router.router(vertx);
		
// 		Creating a UserController object --> responsible for handling requests related to users..		
		UserController controller = new UserController();

//		Defines three routes on the router object --> Each route is associated with a handler method from the UserController object.
		router.get("/api/users").handler(controller::getAllUsers);
		router.post("/api/users").handler(controller::addUser);
		router.put("/api/users/:id").handler(controller::updateUser);
		
//		Associating the router with the HTTP server..		
		server.requestHandler(router);
//		Starting the HTTP server listening on port 8080		
		server.listen(8080);
		
		
		System.out.println("Voilaa..! Vert.X Rest API Server started..!");
		
		// http://localhost:8080/api/users // for accessing the server's API endPoints...:)
	}

}
