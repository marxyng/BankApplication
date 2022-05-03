package dao;

public class EmployeeDAO {
	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	//import org.apache.log4j.BasicConfigurator;
	//import org.apache.log4j.LogManager;
	//import org.apache.log4j.Logger;

	import Revature.BankingApplicationTwo.Driver;
import model.Employee;
import model.User;

	public class EmployeeDAO implements DAOInterface<Employee, String> {

		public void create(Employee element) {
			// TODO Auto-generated method stub
			/*The Algorithm
			 * 1.Create PreparedStatement
			 * 2.Set the ?s for the PreparedStatement using inputs
			 * 3.Exexcute query and, if relevant, get ResultSet
			 * 4If I have one, process ResultSet
			 */
			
			Connection connection = ConnectionManager.getConnection();
			try {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (username, password VALUES(?, ?)");
				statement.setString(1,  element.username);
				statement.setString(2,  element.password);
				
				
				statement.execute();
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

		public User get(int id) {
			
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
					Employee e = new Employee();
					e.employeeID = id;
					e.username = rs.getString("username");
					e.password = rs.getString("password");
					
					return e;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
			 
		}
		

		public void update(User element) {
			Connection connection = ConnectionManager.getConnection();
			try {
				PreparedStatement statement = connection.prepareStatement("UPDATE employees" + "SET username = ?, password = ?"+ "WHERE username = ?");
				statement.setString(1,  element.username);
				statement.setString(2,  element.password);
				
				
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

