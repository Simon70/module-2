package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public interface Function {
    double apply(double x);

    Function derivative();

    @Override
    String toString();
}
