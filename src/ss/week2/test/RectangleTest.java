package ss.week2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;


/**
 * Created by simon on 21.11.16.
 */
public class RectangleTest {

    private Rectangle testRectangle;
    private int length;
    private int width;

    @Before
    public void setup() {
        length = (int) (Math.random() * 40);
        width = (int) (Math.random() * 20);
        testRectangle = new Rectangle(length, width);
    }

    @Test
    public void testLength() {
        Assert.assertEquals("length should be ",length, testRectangle.length());
    }

    @Test
    public void testWidth() {
        Assert.assertEquals("",width, testRectangle.width());
    }

    @Test
    public void testArea() {
        Assert.assertEquals("",length * width, testRectangle.area());
    }

    @Test
    public void testPerimeter() {
        Assert.assertEquals("",2 * length + 2 * width, testRectangle.perimeter());
    }
}
