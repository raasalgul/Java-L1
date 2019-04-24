package com.javaL1.topic2;
/*Write a program to create a class Book with the following data members: isbn, title and price.
Inherit the class Book to two derived classes : Magazine and Novel with the following data
members:
Magazine: type
Novel : author
Populate the details using constructors.
Create a magazine and Novel and display the details.*/
public class Book {
	String title;
	int isbn;
	double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
