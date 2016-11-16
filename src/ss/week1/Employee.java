<<<<<<< HEAD
package ss.week1;

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
=======
package ss.week1;

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
>>>>>>> branch 'master' of https://github.com/Simon70/module-2.git
