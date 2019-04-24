package com.javaL1.topic4;
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
public class Main {
public static void main(String args[])
{
	Factorial fact=new Factorial();
	RandomGenerator rand1=new RandomGenerator(fact);
	RandomGenerator rand2=new RandomGenerator(fact);
	RandomGenerator rand3=new RandomGenerator(fact);
	RandomGenerator rand4=new RandomGenerator(fact);
	RandomGenerator rand5=new RandomGenerator(fact);
}
}
