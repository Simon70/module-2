package ss.week1;

public class DollarsAndCentsCounter {

	private int	dollars;
	private int	cents;

	public int dollars() throws Exception {
		if (this.dollars >= 0) {
			return this.dollars;
		} else {
			throw new Exception("DollarsAndCentsCounter is negative");
		}
	}

	public int cents() throws Exception {
		if (this.cents < 0) {
			throw new Exception("Cents are negative");
		} else if (this.cents > 99) {
			throw new Exception("Cents is too big");
		}
		return this.cents;
	}

	public void add(int dollars, int cents) {
		this.dollars += dollars;
		this.cents += cents;

		while (this.cents > 100) {
			this.dollars += 1;
			this.cents -= 100;
		}
	}

	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}

	public void substract(int dollars, int cents) {
		this.dollars -= dollars;
		this.cents -= cents;

		while (this.cents < 0) {
			this.dollars -= 1;
			this.cents += 100;
		}
	}
}
