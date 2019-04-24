/*
 * Write a Java program to calculate the factorial of a number without using any loop.
 */

package com.javaL1.topic1;

import java.util.Scanner;

public class Main {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int no,fact;
	System.out.println("Enter the number");
	no=sc.nextInt();
	fact=factorial(no);
	System.out.println("The greatest no is "+fact);
	sc.close();
}

private static int factorial(int no) {
	if(no==1)
		return 1;
	return no*factorial(no-1);
}
}
