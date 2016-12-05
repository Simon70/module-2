package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public interface Function {

	/**
	 * Executes the function to an argument of type double.
	 * 
	 * @param x
	 * @return
	 */
	double apply(double x);

	/**
	 * Returns the function object that is the derivative of the current object.
	 * 
	 * @return
	 */
	Function derivative();

	@Override
	String toString();
}
