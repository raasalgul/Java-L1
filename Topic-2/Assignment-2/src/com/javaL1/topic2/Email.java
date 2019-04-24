package com.javaL1.topic2;

/*Define a class named Document that contains a member variable of type String named text that
stores any textual content for the document. Create a method named toString that returns the text
field and also include a method to set this value.
Next, define a class for Email that is derived from Document and includes member variables for
the sender, recipient, and title of an email message. Implement appropriate accessor and mutator
methods. [An accessor is a member function that accesses the contents of an object but does not
modify that object; eg: int getX(return x;)A mutator is a member function that can modify an
object void setX(int x){this.x=x;} ]The body of the email message should be stored in the
inherited variable text. Redefine the toString method to concatenate all text fields.*/
public class Email extends Document{
String sender;
String recipient;
String title;
String message="";
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getRecipient() {
	return recipient;
}
public void setRecipient(String recipient) {
	this.recipient = recipient;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public void setMessage()
{
	this.message+=" "+text;
}
@Override
public String toString()
{
	return "[Sender:"+sender+" Recipient:"+recipient+" Title:"+title+" Message:"+message+"]";
}
public static void main(String args[])
{
	Email email=new Email();
	email.setText("Hello");
	email.setMessage();
	email.setText("I'm Sathish");
	email.setSender("topgear");
	email.setRecipient("Sathish Kumar");
	email.setMessage();
	email.setTitle("Welcome Note");
	System.out.println(email.toString());
}
}
