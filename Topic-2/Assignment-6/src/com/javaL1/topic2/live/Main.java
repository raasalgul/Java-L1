package com.javaL1.topic2.live;

import com.javaL1.topic2.music.Playable;
import com.javaL1.topic2.string.Veena;
import com.javaL1.topic2.wind.Saxophone;

/*
Write an interface called Playable, with a method
void play();
Let this interface be placed in a package called music.
Write a class called Veena which implements Playable interface. Let this class be placed in a
package music.string
Write a class called Saxophone which implements Playable interface. Let this class be placed in
a package music.wind
Write another class Test in a package called live. Then,
a. Create an instance of Veena and call play() method
b. Create an instance of Saxophone and call play() method
c. Place the above instances in a variable of type Playable and then call play()*/
public class Main {

	public static void main(String[] args) {
	Playable veena=new Veena();
	Playable saxophone=new Saxophone();
	veena.play();
	saxophone.play();
	}

}
