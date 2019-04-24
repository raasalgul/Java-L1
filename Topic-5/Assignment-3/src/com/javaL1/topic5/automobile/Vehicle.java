package com.javaL1.topic5.automobile;

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

public abstract class Vehicle {
	public abstract String modelName();
	public abstract String registrationNumber();
	public abstract String ownerName();
}
