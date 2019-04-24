package com.javaL1.topic4;

import java.util.ArrayList;

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
public class EmployeDB {
ArrayList<Employe> al=new ArrayList<Employe>();
boolean addEmploye(Employe e)
{
	try {
		return this.al.add(e);
	}
	catch(Exception exception)
	{
		System.out.println(exception);
	return false;
	}
}
boolean deleteEmploye(int eCode)
{
	try {
	for(Employe employe:al)
	{
		if(employe.getEmployeId()==eCode)
		{
	al.remove(employe);
	return true;
		}
	}
			return false;
	}
	catch(Exception exception)
	{
		System.out.println(exception);
	return false;
	}
	
}
String showPaySlip(int eCode)
{
	for(Employe employe:al)
		if(employe.getEmployeId()==eCode)
	return ""+employe.getSalary();
	return null;
	
}
Employe[] listAll(){
	Employe employe[]=this.al.toArray(new Employe[this.al.size()]);
	return employe;
	
}
}
