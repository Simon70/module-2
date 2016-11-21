package ss.week2.test;

import org.junit.Assert;
import org.junit.Test;
import ss.week2.Rectangle;


/**
 * Created by simon on 21.11.16.
 */
public class RectangleTest {
    @Test
    public void test() {
        int length = 10;
        int width = 20;
        Rectangle testRectangle = new Rectangle(length, width);
        Assert.assertEquals(length, testRectangle.length());
        Assert.assertEquals(width, testRectangle.width());
        Assert.assertEquals(length * width, testRectangle.area());
        Assert.assertEquals(2 * length + 2 * width, testRectangle.perimeter());
    }
}
