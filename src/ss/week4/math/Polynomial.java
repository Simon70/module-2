package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Polynomial implements Function, Integrandable {

	private LinearProduct[] linearProducts;

	/**
	 * 
	 * @param parts
	 *            parts of the arbitrary polynomial function.
	 */
	public Polynomial(double[] parts) {
		linearProducts = new LinearProduct[parts.length];
		for (int i = parts.length - 1; i >= 0; i--) {
			linearProducts[i] = new LinearProduct(new Constant(parts[i]), new Exponent(i));
		}
	}

	@Override
	public double apply(double x) {
		if (linearProducts.length <= 0) {
			return 0;
		}

		double result = 0;
		for (int i = 0; i < linearProducts.length; i++) {
			result += linearProducts[i].apply(x);
		}
		return result;
	}

	@Override
	public Function derivative() {
		if (linearProducts.length <= 0) {
			return null;
		}

		Function sum = linearProducts[0].derivative();
		for (int i = 1; i < linearProducts.length; i++) {
			sum = new Sum(sum, linearProducts[i].derivative());
		}
		return sum;
	}

	@Override
	public Function integrand() {
		if (linearProducts.length <= 0) {
			return null;
		}

		Function sum = linearProducts[0].integrand();
		for (int i = 1; i < linearProducts.length; i++) {
			//Integrand can return null if it's not possible.
			if (sum == null) {
				sum = linearProducts[i].integrand();
				continue;
			}

			Function integrandResult = linearProducts[i].integrand();
			//Only go on with this if the integrand is possible.
			if (integrandResult != null) {
				sum = new Sum(sum, integrandResult);
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i<linearProducts.length;i++) {
			if(i>0) {
				result+=" ";
			}
			result+=linearProducts[i].toString();
			
			if(i<linearProducts.length-1) {
				result+=" +";
			}
		}
		return result;
	}
}
