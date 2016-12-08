<<<<<<< Updated upstream
package ss.week4.math;


public class Homework {
	public static void main(String[] args) {
		LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
		Function f2 = f1.integrand();
		Function f3 = f1.derivative();
		System.out.println("f(x) = " + f1 + ", f(8) =  "+f1.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		Polynomial polynomial = new Polynomial(new double[] { 9.45, 5.23, 3.25, 1.23 });
		f2 = polynomial.integrand();
		f3 = polynomial.derivative();
		System.out.println("f(x) = " + polynomial + ", f(8) =  "+polynomial.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		

		Product f4 = new Product(new Exponent(4), f1);
		f3 = f4.derivative();
		System.out.println("f(x) = " + f4 + ", f(8) =  "+f4.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		Constant f5 = new Constant(10);
		f2 = f5.integrand();
		f3 = f5.derivative();
		System.out.println("f(x) = " + f5 + ", f(8) =  "+f5.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		
	}
}
=======
package ss.week4.math;


public class Homework {
	public static void main(String[] args) {
		LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
		Function f2 = f1.integrand();
		Function f3 = f1.derivative();
		System.out.println("f(x) = " + f1 + ", f(8) =  "+f1.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		Polynomial polynomial = new Polynomial(new double[] { 9.45, 5.23, 3.25, 1.23 });
		f2 = polynomial.integrand();
		f3 = polynomial.derivative();
		System.out.println("f(x) = " + polynomial + ", f(8) =  "+polynomial.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		

		Product f4 = new Product(new Exponent(4), f1);
		f3 = f4.derivative();
		System.out.println("f(x) = " + f4 + ", f(8) =  "+f4.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		Constant f5 = new Constant(10);
		f2 = f5.integrand();
		f3 = f5.derivative();
		System.out.println("f(x) = " + f5 + ", f(8) =  "+f5.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) =  "+f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) =  "+f3.apply(8));
		
		
	}
}
>>>>>>> Stashed changes
