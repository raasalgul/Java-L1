package com.javaL1.topic4;
import java.util.Random;
/*
Write a Java Program, where one thread prints a number ( Generate a random number using 
Math.random) and another thread prints the factorial of that given number. Both the 
outputs should alternate each other.
Eg: Number : 2
Factorial of 2 : 2
Number : 5
Factorial of 5 : 120
The program can quit after executing 5 times.
*/
public class RandomGenerator extends Thread{
	int randomNo;
	Factorial fact;
	RandomGenerator(Factorial fact)
	{
		Random rand=new Random();
		randomNo=rand.nextInt(10);
		this.fact=fact;
		start();
	}
public void run() {
	synchronized(fact)
	{
	fact.display(randomNo);
	}
}
}
