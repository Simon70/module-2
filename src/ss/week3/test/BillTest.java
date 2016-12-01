package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.*;

public class BillTest {

	private Bill bill;

	@Before
	public void setUp() throws Exception {
		bill = new Bill(null);
	}

	@Test
	public void testClose() {
		bill.close();
	}

	@Test
	public void addItems() {
		BillItemBasic newItem = new BillItemBasic("Description", 3.00);

		assertTrue(newItem.toString().equals("Description"));
		
		bill.newItem(newItem);

		BillItemBasic newItem2 = new BillItemBasic("Description2", 1.50);
		
		assertTrue(newItem2.toString().equals("Description2"));

		bill.newItem(newItem2);

		//assertEquals("", bill.getSum(), newItem.getAmount() + newItem2.getAmount());
		assertTrue(bill.getSum() == newItem.getAmount()+newItem2.getAmount());

		bill.close();
	}
}
