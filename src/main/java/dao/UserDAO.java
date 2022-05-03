package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

import Revature.BankingApplicationTwo.Driver;
import model.User;

public class UserDAO implements DAOInterface<User, String> {

	public void create(User element) {
		// TODO Auto-generated method stub
		/*The Algorithm
		 * 1.Create PreparedStatement
		 * 2.Set the ?s for the PreparedStatement using inputs
		 * 3.Exexcute query and, if relevant, get ResultSet
		 * 4If I have one, process ResultSet
		 */
		
		Connection connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name, birth_month, balance) VALUES(?, ?, ?, ?, ?, ?)");
			statement.setString(1,  element.username);
			statement.setString(2,  element.password);
			statement.setString(3, element.firstName);
			statement.setString(4,  element.lastName);
			statement.setString(5, element.birthMonth);
			statement.setInt(6,  element.balance);
			
			statement.execute();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public User get(String id) {
		
		Connection connection = ConnectionManager.getConnection();
		
		try {
			//step1
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? ");
			
			//step2
			statement.setString(1, id);
			
			//step3
			ResultSet rs = statement.executeQuery();
			
			//step4
			if(rs.next()) {
				User u = new User();
				u.username = id;
				u.password = rs.getString("password");
				u.firstName = rs.getString("first_name");
				u.lastName = rs.getString("last_name");
				u.birthMonth=rs.getString("birth_month");
				u.balance = rs.getInt("balance");
				
				return u;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		 
	}
	

	public void update(User element) {
		Connection connection = ConnectionManager.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE users" + "SET password = ?, first_name=?, last_name = ?, birth_month = ?, balance = ?"+ "WHERE username = ?");
			statement.setString(1,  element.password);
			statement.setString(2,  element.firstName);
			statement.setString(3, element.lastName);
			statement.setString(4, element.birthMonth);
			statement.setString(5, element.username);
			statement.setInt(6,  element.balance);
			
			statement.executeUpdate();
		}catch(Exception e ) {
		e.printStackTrace();
	
	}
	}

	public void delete(User element) {
	Connection connection = ConnectionManager.getConnection();
	
	try {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE username = ?");
		
		statement.setString(1,  element.username);
		
		statement.execute();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	

}
