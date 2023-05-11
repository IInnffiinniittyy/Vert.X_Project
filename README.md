# Vert.X_Project
<img height=150px src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Vert.x_Logo.svg/768px-Vert.x_Logo.svg.png?20150609114807" />

## Problem Statement.

- To build a GET, PUT and POST API using the VertX framework.

- Focus areas : “Core”, “Web” & “Database Client” sections.

- To create a “user_info” table in the database with the following columns – “id - UUID”, “name – varchar(64)”, “email – varchar(64)”, “gender – enum (male, female)”, “status – enum (active, inactive)”, “timestamp – datetime with timezone”. 

- The id column is the primary key – a new UUID should be generated when the user is created & timestamp should be updated whenever the user record is created or updated with the current system time.

- Following 3 API need to the exposed and tested using postman : 

-  GET API:  <br/>
 --> Fetches all the records from the user_info table and returns the response in a JSON array. <br/>
 --> The end point would be “/api/users” with the GET method. <br/>
 --> Should return HTTP status 200 for success.
 
-  POST API:  <br/>
 --> Create a new user – POST to “/api/users”. <br/>
 --> The user JSON object will be sent in the body with fields “name”, “email”, “gender” & “status”. <br/>
 --> The response will be a JSON object that contains the “{ id: <new UUID of the user> }”.
  
-  PUT API:  <br/>
 --> To update a specific user record – PUT to “/api/users/<uuid>”. <br/>
 --> The user JSON object will be sent in the body with fields “id”, “name”, “email”, “gender” & “status”. <br/>
 --> The response will be a JSON object that contains the “{ id: <UUID of user record updated> }”.  

<hr/>

## Technology and Tools Used : 
- Core Java
- Vert.X library
- MySQL database
- JDBC-DAO pattern
- Git bash
- Eclipse IDE
- Postman
- Google Chrome
- Notepad
 
<hr/>

## How to run the program.
- Simply clone this repository on your local system.
  
- Open with an IDE that has good support/environment for Java. 
  
- Force update the project so that all the dependencies of build tools would get resolved for smooth running of the application.
  
- Go to the utility package and change the database information as per your system. (You can test, whether connection with the database established or not in your system by running the utility.Testing_Connection.java class) <br/>
 -->Note: you need to create the table in the database as per the given problem statement before proceeding further. Thanks!
  
- Now go to the MainVerticle.java class and Run as java application. (You will get the message "server started" in the console)
  
- Now use Postman to expose/test the given APIs with API root end point :
```
http://localhost:8080/api/users
```

Thank you!
  
<hr/>
  
## Author

- [Tanuj Pant](https://github.com/IInnffiinniittyy)


## Contact Me

- [LinkedIn](https://www.linkedin.com/in/tanujpant6263/)
- Email : tanuj813@gmail.com 
  
  
