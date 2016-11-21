package ss.week1;

import org.junit.Ignore;

public class DollarsAndCentsCounter {

	private int dollars;
	private int cents;

	public int dollars() {
		if (dollars < 0) {
			System.out.println("DollarsAndCentsCounter is negative");
		}
		return dollars;
	}

	public int cents() {
		if (this.cents < 0) {
			System.out.println("Cents are negative");
		} else if (this.cents > 99) {
			System.out.println("Cents is too big");
		}
		return this.cents;
	}

	public void add(int dollars, int cents) {
		this.dollars += dollars;
		this.cents += cents;

		while (this.cents > 99) {
			this.dollars += 1;
			this.cents -= 100;
		}
	}

	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}
}
