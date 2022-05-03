package controller;

	//import java.util.logging.Handler;
	import io.javalin.Javalin;
	import io.javalin.http.Handler;
	import model.User;
	import dao.UserDAO;

	//import model.User;

	public class UserController {
		UserDAO dao;

		public UserController(Javalin app) {
			dao = new UserDAO();
			
			app.get("/users/{username", getHandler);
		}
		
		

		public Handler getHandler = ctx -> {
			//get the path's username
			String username = ctx.pathParam("username");
			
			//get the user based on the username
			User user = dao.get(username);
			
			//Turns the given Java object into JSON format,
			//which is a text format understood by almost everybody
			//and can be used in any system running any technology
			//think of json as a universal data transfer format
			ctx.json(user);
		};
		
		//The 'create' command
		public Handler postHandler = ctx -> {
			
			//turn the body of the request from json (ie text) into a real
			//java object
			
			User user = ctx.bodyAsClass(User.class);
			
			dao.create(user);
			
			ctx.status(201);
		};
		
		public Handler putHandler = ctx -> {
			User user = ctx.bodyAsClass(User.class);
			
			dao.update(user);
			
			ctx.status(200);
		};
		
		public Handler deleteHandler = ctx -> {
			User user = ctx.bodyAsClass(User.class);
			dao.delete(user);
			ctx.status(200);
		};
	}



