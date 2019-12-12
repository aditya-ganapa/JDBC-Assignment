package q1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertEmployeeBO {
	public static void main(String[] args) {
		System.out.println("Enter the Employee details\nEnter the ID:");
		Scanner scanner = new Scanner(System.in);
		int employeeId = scanner.nextInt();
		System.out.println("Enter the Name:");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter the Date of birth (dd/MM/yyyy):");
		Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter the Salary:");
		int salary = scanner.nextInt();
		Employee employee = new Employee(employeeId, name, dateOfBirth, salary);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.addEmployee(employee);
		scanner.close();
	}
}