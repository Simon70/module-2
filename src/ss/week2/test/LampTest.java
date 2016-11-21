
package ss.week2.test;

import org.junit.Assert;
import org.junit.Test;

import ss.week2.Lamp;


public class LampTest {

	@Test
	public void test() {
		Lamp testLamp = new Lamp();
		
		Assert.assertEquals("Default state has to be off.", Lamp.LampOptions.OFF, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be low", Lamp.LampOptions.LOW, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be medium", Lamp.LampOptions.MEDIUM, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be high", Lamp.LampOptions.HIGH, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be off", Lamp.LampOptions.OFF, testLamp.getStatus());
	}

}
