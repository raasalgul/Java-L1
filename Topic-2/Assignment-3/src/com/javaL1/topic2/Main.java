package com.javaL1.topic2;
/*Write a program to create a class Book with the following data members: isbn, title and price.
Inherit the class Book to two derived classes : Magazine and Novel with the following data
members:
Magazine: type
Novel : author
Populate the details using constructors.
Create a magazine and Novel and display the details.*/

public class Main {

	public static void main(String[] args) {
		Magazine magazine=new Magazine(1, "Play boy", "Adult", 99.99);
		Novel novel=new Novel(2, "Game Of Thrones the song of ice and fire", "Fantacy", 589.99);
		System.out.println(magazine.toString());
		System.out.println(novel.toString());
	}

}
