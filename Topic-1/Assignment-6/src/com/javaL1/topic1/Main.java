/*
 * Write a program to find greatest number in an array
 */

package com.javaL1.topic1;

import java.util.Scanner;

public class Main {
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int no;
	System.out.println("Enter the array size");
	no=sc.nextInt();
	int arr[]=new int[no];
	System.out.println("Enter the array elements");
	int greatest=0;
	for(int i=0;i<no;i++)
	{
		arr[i]=sc.nextInt();
		if(arr[i]>greatest)
			greatest=arr[i];
	}
	System.out.println("The greatest no is "+greatest);
	sc.close();
}
}
