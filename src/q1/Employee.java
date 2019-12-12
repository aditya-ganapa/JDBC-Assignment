package q1;

import java.util.Date;

public class Employee {
	private int employeeId;
	private String name;
	private Date dateOfBirth;
	private int salary;
	
	public Employee(int employeeId, String name, Date dateOfBirth, int salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}