package com.javaL1.topic2;
/*Write a program to create a class Book with the following
- attributes: -isbn, title, author, price
- methods :
i. Initialize the data members through parameterized constructor
ii. displaydeta ils() to display the details of the book
iii. discountedprice() : pass the discount percent, calculate the discount on price and find
the amount to be paid after discount
- task :
Create an object book, initialize the book and display the details along with the discounted
price*/
public class Book {
	int isbn;
	String title;
	String author;
	double price;
Book(int isbn,String title,String author,double price)
{
	this.isbn=isbn;
	this.title=title;
	this.author=author;
	this.price=price;
}
void displaydetails()
{
	System.out.println("book id: "+isbn+"\nbook title: "+title+"\nAuthor: "+author+"\nprice: "+price);
}
void discountedprice(int percentage)
{
	double discountPrice;
	discountPrice=price*percentage/100;
	System.out.println("Discounted price: "+(price-discountPrice));
}
public static void main(String args[])
{
	Book book=new Book(1,"Game of thrones the song of ice and fire","Geroge RR Martine",543.99);
	book.displaydetails();
	book.discountedprice(8);
}
}
