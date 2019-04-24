package com.javaL1.topic3;

/*
 *Write a program to accept 5 integers passed as arguments while executing the class. 
 *Find the average of these 5 nos. Use ArrayIndexOutofBounds 
 *exception to handle situation where the user might have entered less than 5 integers.*/
public class Main {
	
	public static void main(String[] args) {
		try
		{
			double avg=0;
			int input[]=new int[5];
			for(int i=0;i<5;i++)
			{
				input[i]=Integer.parseInt(args[i]);
				avg+=input[i];
			}
			avg/=5;
			System.out.println("The average is "+avg);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("The arguments given is less than 5");
		}
	}

	
	}
