package com.javaL1.topic2;

/*Define a class named Payment that contains a member variable of type double that stores the
amount of the payment and appropriate accessor and mutator methods. Also create a method
named paymentDetails that outputs an English sentence to describe the amount of the payment.
Next, define a class named CashPayment that is derived from Payment. This class should
redefine the paymentDetails method to indicate that the payment is in cash. Include appropriate
constructor(s).
Define a class named CreditCardPayment that is derived from Payment. This class should
contain member variables for the name on the card, expiration date, and credit card number.
Include appropriate constructor(s). Finally, redefine the paymentDetails method to include all
credit card information in the printout.
Create a main method that creates at least two CashPayment and two
CreditCardPayment objects with different values and calls paymentDetails for each.*/

public class Main {

	public static void main(String[] args) {
		CashPayment cash1=new CashPayment(250.65);
		cash1.paymentDetails();
		CreditCardPayment card1=new CreditCardPayment("Sathish Kumar", "123456789009876", "11/24", 9043.32);
		card1.paymentDetails();
		CashPayment cash2=new CashPayment(894.99);
		cash2.paymentDetails();
		CreditCardPayment card2=new CreditCardPayment("Karthik", "809342234254332", "01/29", 9043.32);
		card2.paymentDetails();
	}

}
