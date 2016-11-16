<<<<<<< HEAD
package main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Lamp.LampOptions;
=======
package ss.week1;

import static org.junit.Assert.*;

import org.junit.Test;
>>>>>>> branch 'master' of https://github.com/Simon70/module-2.git


public class Lamp2Test {

	@Test
	public void test() {
		Lamp2 testLamp = new Lamp2();
		
		assertEquals("Default state has to be off.", Lamp2.OFF, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be low", Lamp2.LOW, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be medium", Lamp2.MEDIUM, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be high", Lamp2.HIGH, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be off", Lamp2.OFF, testLamp.getStatus());
	}

}
