package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Polynomial implements Function {

	private LinearProduct[] linearProducts;

	/**
	 * 
	 * @param parts
	 *            parts of the arbitrary polynomial function.
	 */
	public Polynomial(double[] parts) {
		linearProducts = new LinearProduct[parts.length];
		for (int i = parts.length - 1; i >= 0; i++) {
			linearProducts[i] = new LinearProduct(new Constant(parts[i]), new Exponent(i));
		}
	}

	@Override
	public double apply(double x) {
		if(linearProducts.length<=0) {
			return 0;
		}

		double result = 0;
		for(int i = 1; i<linearProducts.length;i++) {
			result+=linearProducts[i].apply(x);
		}
		return result;
	}

	@Override
	public Function derivative() {
		if(linearProducts.length<=0) {
			return null;
		}
		
		Function sum = linearProducts[0].derivative();
		for(int i = 1; i<linearProducts.length;i++) {
			sum = new Sum(sum,linearProducts[i].derivative());
		}
		return sum;
	}
}
