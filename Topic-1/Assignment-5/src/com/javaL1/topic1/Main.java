/*
 * Write a program that will accept a 4 digit number(assume that the user enters only 4 
 * digit nos.) and print the sum of all the 4 digits. For ex : If the number passed is 3629,
 * the program should print “The sum of all the digits entered is 20”
 */

package com.javaL1.topic1;

import java.util.Scanner;

public class Main {
public static void main(String args[])
{
	int number,sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the four digit number");
	number=sc.nextInt();
	while(number>0)
	{
		sum+=number%10;
		number/=10;
	}
	System.out.println("The sum is "+sum);
	sc.close();
}
}
