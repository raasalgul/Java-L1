package com.javaL1.topic5.automobile.twoWheeler;

import com.javaL1.topic5.automobile.Vehicle;
/*
Create a package called Automobile. Define an abstract class called Vehicle.
Vehicle class has the following abstract methods:
public String modelName()
public String registrationNumber()
public String ownerName()
Create TwoWheeler subpackage under Automobile package
Hero class extends Automobile.vehicle class
public int speed() – Returns the current speed of the vehicle.
public void radio() – provides facility to control the radio device
Honda class extends Automobile.vehicle class
public int speed()– Returns the current speed of the vehicle. 
 */
public class Hero extends Vehicle{
int speed=150;
String modelName="A8";
String registrationNumber="4321";
String ownerName="Sathish";
	@Override
	public String modelName() {
		// TODO Auto-generated method stub
		return modelName;
	}

	@Override
	public String registrationNumber() {
		// TODO Auto-generated method stub
		return registrationNumber;
	}

	@Override
	public String ownerName() {
		// TODO Auto-generated method stub
		return ownerName;
	}
	public void radio() {
		System.out.println("Provides facility to control the radio device");
	}
	public int speed() {
		return speed;
	}

}
