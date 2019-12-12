package q1;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeDAO {
	private static Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "password-1");
		} catch (SQLException e) {
			return null;
		}
	}
	public void addEmployee(Employee employee) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		int result = -1;
		try {
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
		//	preparedStatement.setDate(3, (Date) employee.getDateOfBirth());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			preparedStatement.setString(3, dateFormat.format(employee.getDateOfBirth()));
			preparedStatement.setInt(4, employee.getSalary());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println("The Given data is successfully inserted to the database.");
		}
	}
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> arrayList = new ArrayList<Employee>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("select * from employee");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(3)), resultSet.getInt(4));
				arrayList.add(employee);
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
}