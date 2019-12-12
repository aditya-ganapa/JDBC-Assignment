package q2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import q1.Employee;
import q1.EmployeeDAO;

public class GetEmployeeBO {
	public void display(ArrayList<Employee> employeeList) {
		for (Employee employee : employeeList)
			System.out.println(employee.getName()+" "+new SimpleDateFormat("dd/MM/yyyy").format(employee.getDateOfBirth())+" "+employee.getSalary());
	}
	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList<Employee> employeeList = employeeDAO.getAllEmployees();
		GetEmployeeBO getEmployeeBO = new GetEmployeeBO();
		getEmployeeBO.display(employeeList);
	}
}