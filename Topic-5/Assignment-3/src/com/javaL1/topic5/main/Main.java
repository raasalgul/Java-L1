package com.javaL1.topic5.main;

import com.javaL1.topic5.automobile.twoWheeler.Hero;
import com.javaL1.topic5.automobile.twoWheeler.Honda;

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
public class Main {

	public static void main(String[] args) {
		Hero hero=new Hero();
		Honda honda=new Honda();
		System.out.print(hero.modelName()+" "+hero.ownerName()+" "+hero.registrationNumber()+" "+hero.speed()+" ");
		hero.radio();
		System.out.println(honda.modelName()+" "+honda.ownerName()+" "+honda.registrationNumber()+" "+honda.speed());
	}

}
