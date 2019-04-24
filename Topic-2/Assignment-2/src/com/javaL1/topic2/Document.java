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
public class Document {
	String text;
	@Override
	public String toString()
	{
		return "1"+text;
	}
	
public void setText(String text) {
		this.text = text;
	}

public static void main(String args[])
{
	}
}
