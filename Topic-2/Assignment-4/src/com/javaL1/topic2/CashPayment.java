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
public class CashPayment extends Payment{
CashPayment(double amount)
{
	this.setAmount(amount);
	super.paymentDetails();
}
@Override
void paymentDetails()
{
	System.out.println("The payment method is cash");
}
}
