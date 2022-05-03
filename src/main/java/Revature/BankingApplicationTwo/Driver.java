package Revature.BankingApplicationTwo;
	import io.javalin.Javalin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.UserController;

	public class Driver {
		public static final Object amount = null;
		public static final Object deposit = null;
		
		public static Logger logger = LogManager.getLogger(Driver.class);
		public static Object Register;
		public static void main(String[] args) {
			
			Javalin app = Javalin.create().start(8080);
			
			UserController userController = new UserController(app);
			
		}

	}

