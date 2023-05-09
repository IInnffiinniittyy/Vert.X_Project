package com.finolitech;

import com.finolitech.controller.UserController;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class MainVerticle {

	public static void main(String[] args) {
		
		
		Vertx vertx = Vertx.vertx();
		
		HttpServer server = vertx.createHttpServer();
		
		//Router is used to handle the HTTP request
		Router router = Router.router(vertx);
		
		UserController controller = new UserController();
		
		router.get("/api/users").handler(controller::getAllUsers);
		router.post("/api/users").handler(controller::addUser);
		router.put("/api/users/:id").handler(controller::updateUser);
		
		
		server.requestHandler(router);
		server.listen(8080);
		
		
		System.out.println("Vert.X Rest API Server started..!");
		
	}

}
