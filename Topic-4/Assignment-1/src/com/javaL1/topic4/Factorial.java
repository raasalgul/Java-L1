package com.javaL1.topic4;
/*
Write a Java Program, where one thread prints a number ( Generate a random number using 
Math.random) and another thread prints the factorial of that given number. Both the 
outputs should alternate each other.
Eg: Number : 2
Factorial of 2 : 2
Number : 5
Factorial of 5 : 120
The program can quit after executing 5 times.
*/
public class Factorial{
int number,fact=1;

	public void display(int number) {
		for(int i=1;i<number;i++)
			fact*=i;
		System.out.println("Number : "+number);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Factorial of "+number+": "+fact);
	}

}
