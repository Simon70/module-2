<<<<<<< HEAD
import static org.junit.Assert.*;

import main.Lamp;
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
=======
package ss.week1;

import org.junit.Assert;
import org.junit.Test;


public class LampTest {

	@Test
	public void test() {
		Lamp testLamp = new Lamp();
		
		Assert.assertEquals("Default state has to be off.", Lamp.LampOptions.off, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be low", Lamp.LampOptions.low, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be medium", Lamp.LampOptions.medium, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be high", Lamp.LampOptions.high, testLamp.getStatus());
		
		testLamp.changeStatus();
		Assert.assertEquals("Next state has to be off", Lamp.LampOptions.off, testLamp.getStatus());
>>>>>>> branch 'master' of https://github.com/Simon70/module-2.git
	}

}
