package com.javaL1.topic4;

import java.util.HashMap;
import java.util.Scanner;

/*
Write a program creates a HashMap to store name and phone number (Telephone 
book). When name is give, we can get back the corresponding phone number.
 */
public class Main {
public static void main(String args[])
{
	HashMap<String,String> hash=new HashMap<String,String>();
	hash.put("Sathish", "1234567890");
	hash.put("Karthik", "0987654321");
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the name");
	String name=sc.nextLine();
	System.out.println("The number of "+name+" is "+hash.get(name));
	sc.close();
}
}
