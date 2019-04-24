/*
 * Write a Java program to convert minutes into a number of years and days
 */

package com.javaL1.topic1;

import java.util.Scanner;

public class Main {
public static void main(String args[])
{
	int minutes;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the minutes");
	minutes=sc.nextInt();
	int days=minutes/60/24;
	int years=days/365;
	System.out.println("Days: "+days+" Years: "+years);
	sc.close();
}
}
