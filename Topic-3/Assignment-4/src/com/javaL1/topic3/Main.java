package com.javaL1.topic3;

import java.util.Scanner;

/*Write a program to check the no.of occurrences of a given character within the given string
without using any loop. [Hint: String str=”How was your day today”; char c=’a’; no.of
occurrences of a is=3]*/
public class Main {
	
	public static void main(String[] args) {
		String str;
		System.out.println("Enter the string");
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		Boolean isPalin=isPalindrome(str,0,str.length()-1);
		if(isPalin)
			System.out.println("It is a Palindrome");
		else
			System.out.println("It is not a Palindrome");
		sc.close();

	}

	private static Boolean isPalindrome(String str, int start,int end) {
		if(start>end)
			return true;
		if(str.charAt(start)==str.charAt(end))
			return true&isPalindrome(str,start+1,end-1);
		else
			return false;
	}

	}
