package main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Lamp.LampOptions;


public class LampTest {

	@Test
	public void test() {
		Lamp testLamp = new Lamp();
		
		assertEquals("Default state has to be off.", LampOptions.off, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be low", LampOptions.low, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be medium", LampOptions.medium, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be high", LampOptions.high, testLamp.getStatus());
		
		testLamp.changeStatus();
		assertEquals("Next state has to be off", LampOptions.off, testLamp.getStatus());
	}

}
