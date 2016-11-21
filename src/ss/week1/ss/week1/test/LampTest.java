
package ss.week1.ss.week1.test;

import org.junit.Assert;
import org.junit.Test;
import ss.week1.Lamp;


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
	}

}
