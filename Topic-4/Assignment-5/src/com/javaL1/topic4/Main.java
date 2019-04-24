package com.javaL1.topic4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
Write a program to store a group of employee names into a HashSet, retrieve 
the elements one by one using an Iterator.
 */
public class Main {
public static void main(String args[])
{
	HashSet<String> set=new HashSet<String>();
	set.add("Sathish");
	set.add("Karthik");
	set.add("John Snow");
	set.add("Maise Willams");
	set.add("Emilea clarke");
	Iterator itr=set.iterator();
	System.out.println("Employe names are");
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
}
}
