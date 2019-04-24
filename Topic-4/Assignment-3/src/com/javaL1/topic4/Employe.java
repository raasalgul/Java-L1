package com.javaL1.topic4;
/*
Create an Employee class with the related attributes and behaviours. Create one more class 
EmployeeDB which has the following methods.
a. boolean addEmployee(Employee e)
b. boolean deleteEmployee(int eCode)
c. String showPaySlip(int eCode)
d. Employee[] listAll()
Use an ArrayList which will be used to store the emplyees and use enumeration/iterator to 
process the employees.
 */
public class Employe {
private int employeId;
private String employeName;
private String employeRole;
private double salary;
public int getEmployeId() {
	return employeId;
}
public void setEmployeId(int employeId) {
	this.employeId = employeId;
}
public String getEmployeName() {
	return employeName;
}
public void setEmployeName(String employeName) {
	this.employeName = employeName;
}
public String getEmployeRole() {
	return employeRole;
}
public void setEmployeRole(String employeRole) {
	this.employeRole = employeRole;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
