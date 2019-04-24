package com.javaL1.topic3;

/*
 *Write a Program to take care of Number Format Exception if user enters values other that
 *integer for calculating average marks of 2 students. The name of the students and marks
 *in 3 subjects are passed as arguments while executing the program..*/
public class Main {
	
	public static void main(String[] args) {
		try
		{
			double avg1=0,avg2=0;
			int mark1[]=new int[3];
			int mark2[]=new int[3];
			String name1=args[0];
			int j=0;
			for(int i=1;i<4;i++)
			{
				mark1[j++]=Integer.parseInt(args[i]);
				avg1+=mark1[j-1];
			}

			avg1/=3;
			System.out.println("The average of "+name1+" is "+avg1);
			String name2=args[4];
			 j=0;
			for(int i=5;i<8;i++)
			{
				mark2[j++]=Integer.parseInt(args[i]);
				avg2+=mark2[j-1];
			}
			avg2/=3;
			System.out.println("The average of "+name2+" is "+avg2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
	}
