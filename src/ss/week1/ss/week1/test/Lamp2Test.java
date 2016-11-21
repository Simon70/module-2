package ss.week1.ss.week1.test;

import static org.junit.Assert.*;

import org.junit.Test;
import ss.week1.Lamp2;


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
