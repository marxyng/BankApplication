package dao;

import java.sql.DriverManager;

import java.sql.Connection;


	public class ConnectionManager {
		
		private static String connectionURL = "jdbc:postgresql://salt.db.elephantsql.com:5432/khwbgdgg",
				username="khwbgdgg",
				password="kx9nlF_Pqcqez7-7OZo2T9uh-wtF6R5t";
		
		private static Connection connection;
		
		public static Connection getConnection() {
			try {
				if(connection == null || connection.isClosed()) {
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(connectionURL, username, password);
				}
				return connection;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	}


