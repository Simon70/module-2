package main;

public class Employee {

	private int		hours;
	private double	rate;

	public double pay() {
		double weekPay;

		if (hours > 40) {
			weekPay = rate * 40;
			weekPay += 1.5 * rate * (hours - 40);
		} else {
			weekPay = rate * hours;
		}
		return weekPay;
	}
}
