package com.javaL1.topic2;

/*Write a program to create a class Book with the following data members: isbn, title and price.
Inherit the class Book to two derived classes : Magazine and Novel with the following data
members:
Magazine: type
Novel : author
Populate the details using constructors.
Create a magazine and Novel and display the details.*/
public class Novel extends Book{
String author;
Novel(int isbn,String title,String author,double price)
{
	this.isbn=isbn;
	this.title=title;
	this.author=author;
	this.price=price;
}
@Override
public String toString()
{
	return "[isbn: "+isbn+" title: "+title+" author:"+author+" price:"+price+"]";
}
}
