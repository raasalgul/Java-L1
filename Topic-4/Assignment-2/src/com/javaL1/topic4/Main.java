package com.javaL1.topic4;

import java.time.LocalTime;

/*
Write a Java Program which will print the current time on the console every 2 
seconds. After doing this activity for 20 seconds the program quits.
 */
public class Main {
public static void main(String args[]) throws InterruptedException
{
	 
for(int i=0;i<10;i++)
{
	System.out.println(LocalTime.now());
	Thread.sleep(2000);
}
}
}
