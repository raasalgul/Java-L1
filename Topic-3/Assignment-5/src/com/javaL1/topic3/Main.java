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
		int count[]=new int[26];
		char[] small= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		stringOccurance(str,small,count,str.length()-1);
		
		sc.close();

	}

	private static void stringOccurance(String str, char[] small, int[] count,int length) {
		if(length<0)
			return;
		charCount(str.charAt(length),small,count,25);
		stringOccurance(str,small,count,length-1);
		if(length==0)
		print(small,count,25);
	}

	private static void print(char[] small, int[] count,int length) {
		if(length<0)
			return;
		if(count[length]>0)
			System.out.println("no. of occurrences of "+small[length]+" is = "+count[length]);
		print(small,count,length-1);
	}

	private static void charCount(char charAt, char[] small, int[] count,int length) {
		if(length<0)
			return;
		if(charAt==small[length])
		{
			count[length]++;
			return;
		}
		charCount(charAt,small,count,length-1);
	}

}
