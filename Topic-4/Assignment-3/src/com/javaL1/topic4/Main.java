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
public class Main {
public static void main(String args[])
{
	EmployeDB employeDb=new EmployeDB();
	Employe e1=new Employe();
	e1.setEmployeId(1);
	e1.setEmployeName("Sathish");
	e1.setEmployeRole("full stack developer");
	e1.setSalary(330000);
	employeDb.addEmploye(e1);
	Employe e2=new Employe();
	e2.setEmployeId(2);
	e2.setEmployeName("Jeeva");
	e2.setEmployeRole("java developer");
	e2.setSalary(360000);
	employeDb.addEmploye(e2);
	Employe e3=new Employe();
	e3.setEmployeId(3);
	e3.setEmployeName("Sam");
	e3.setEmployeRole("UI developer");
	e3.setSalary(430000);
	employeDb.addEmploye(e3);
	System.out.println("Add Method");
	Employe[] employeList=employeDb.listAll();
	for(Employe employe:employeList)
	{
		System.out.println(employe.getEmployeName()+":"+employe.getEmployeRole());
	}
	System.out.println("--------------------------------------------");
	System.out.println("Delete Method");
	employeDb.deleteEmploye(1);
	Employe[] employeList1=employeDb.listAll();
	for(Employe employe:employeList1)
	{
		System.out.println(employe.getEmployeName()+":"+employe.getEmployeRole());
	}
	System.out.println("--------------------------------------------");
	System.out.println("showPaySlip Method");
	System.out.println(e2.getEmployeName()+":"+employeDb.showPaySlip(2));
}
}
