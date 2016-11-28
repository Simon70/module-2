package ss.week3.hotel;

import java.io.PrintStream;

/**
 * Created by simon on 28.11.16.
 */
public class Bill {

	public static interface Item {

		public double getAmount();
	}

	private PrintStream	outStream;
	private float		totalBill;

	public Bill(PrintStream outStream) {
		this.outStream = outStream;
		totalBill = 0;
	}

	public void close() {
		if (outStream != null) {
			outStream.println(totalBill);
		}
	}

	public double getSum() {
		return totalBill;
	}

	public void newItem(Item item) {
		if(outStream!=null) {
			outStream.println(item.toString());
		}
		totalBill += item.getAmount();
	}
}
