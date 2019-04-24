package com.javaL1.topic3;

/*
 Write a program to accept name and age of a person from the command prompt
 (passed as arguments when you execute the class) and ensure that the age entered is >=18
 and < 60. Display proper error messages. The program must exit gracefully after displaying
 the error message in case the arguments passed are not proper. (Hint : Create a user 
 defined exception class for handling errors.)*/
public class Main {
	
	public static void main(String[] args) {
		try
		{
			String name=args[0];
			int age=Integer.parseInt(args[1]);
			if(age<18)
			{
				throw new AgeException("Age is less than 18");
			}
			else if(age>60)
			{
				throw new AgeException("Age is greater than 60");
			}
			System.out.println("The age of "+name+" is "+age);
		}
		catch(AgeException e)
		{
			System.out.println(e);
		}
	}

	
	}
