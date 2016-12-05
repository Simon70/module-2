package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Sum implements Function {

	private Function	func0;
	private Function	func1;

	/**
	 * Create a function that is the sum of two functions.
	 * 
	 * @param func0
	 *            First function.
	 * @param func1
	 *            Second function.
	 */
	public Sum(Function func0, Function func1) {
		this.func0 = func0;
		this.func1 = func1;
	}

	@Override
	public double apply(double x) {
		return func0.apply(x) + func1.apply(x);
	}

	@Override
	public Function derivative() {
		return new Sum(func0.derivative(), func1.derivative());
	}
}
