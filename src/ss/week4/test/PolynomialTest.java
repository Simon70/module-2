package ss.week4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.*;

public class PolynomialTest {

	public static final int		CONSTANT_VALUE	= 50;
	private static final double	DELTA			= 1e-15;

	@Test
	public void testApply() {
		assertEquals(262853, new Polynomial(new double[] { 3, 7, 5, 2 }).apply(CONSTANT_VALUE), DELTA);
		
		//1.23 * x ^ 3 + 3.25 * x ^ 2 + 5.23 * x ^ 1 + 9.45
		assertEquals(162145.95, new Polynomial(new double[] { 9.45, 5.23, 3.25, 1.23 }).apply(CONSTANT_VALUE), DELTA);
	}

	@Test
	public void testDerivative() {
		//1.23 * x ^ 3 + 3.25 * x ^ 2 + 5.23 * x ^ 1 + 9.45
		Polynomial polynomial = new Polynomial(new double[] { 9.45, 5.23, 3.25, 1.23 });
		assertTrue(polynomial.derivative() instanceof Sum);

		//5.23 + 6.5 x + 3.69 x^2
		assertEquals(9555.23, polynomial.derivative().apply(CONSTANT_VALUE), DELTA);
	}

	@Test
	public void testIntegrand() {
		//1.23 * x ^ 3 + 3.25 * x ^ 2 + 5.23 * x ^ 1 + 9.45
		Polynomial polynomial = new Polynomial(new double[] { 9.45, 5.23, 3.25, 1.23 });
		
		System.out.println(polynomial.toString());
		
		assertTrue(polynomial instanceof Integrandable);
		assertTrue(polynomial.integrand() instanceof Sum);
		
		Function sum = polynomial.integrand();
		System.out.println(sum.toString());
		
		//9.45 x + 2.615 x^2 + 1.08333 x^3 + 0.3075 x^4
		assertEquals(2.06e6,polynomial.integrand().apply(CONSTANT_VALUE),0.1);
	}
}
