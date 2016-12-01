package ss.project.test;

import org.junit.Before;
import org.junit.Test;
import ss.project.shared.Vector3;
import ss.project.shared.WorldPosition;

import static org.junit.Assert.*;

public class Vector3Test {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void newVector3() {
        Vector3 newVector = new Vector3(0, 0, 0);
        assertNotNull("New vector should not be null.", newVector);

        assertEquals("x should be equal to 0.", newVector.getX(), 0);
        assertEquals("y should be equal to 0.", newVector.getY(), 0);
        assertEquals("z should be equal to 0.", newVector.getZ(), 0);

        newVector = new Vector3(1, 2, 3);
        assertNotNull("New vector should not be null.", newVector);

        assertEquals("x should be equal to 1.", newVector.getX(), 1);
        assertEquals("y should be equal to 2.", newVector.getY(), 2);
        assertEquals("z should be equal to 3.", newVector.getZ(), 3);
    }

    @Test
    public void staticVectorOne() {
        Vector3 staticVector = Vector3.ONE;

        assertNotNull("Static vector should not be null.", staticVector);

        assertEquals("x should be equal to 1.", staticVector.getX(), 1);
        assertEquals("y should be equal to 1.", staticVector.getY(), 1);
        assertEquals("z should be equal to 1.", staticVector.getZ(), 1);
    }

    @Test
    public void staticVectorZero() {
        Vector3 staticVector = Vector3.ZERO;

        assertNotNull("Static vector should not be null.", staticVector);

        assertEquals("x should be equal to 0.", staticVector.getX(), 0);
        assertEquals("y should be equal to 0.", staticVector.getY(), 0);
        assertEquals("z should be equal to 0.", staticVector.getZ(), 0);
    }

    @Test
    public void testEquals() {
        Vector3 staticVector = Vector3.ZERO;

        assertTrue(staticVector.equals(staticVector));
        assertTrue(staticVector.equals(Vector3.ZERO));

        assertFalse(staticVector.equals(new Vector3(1, 0, 0)));
        assertFalse(staticVector.equals(new Vector3(0, 1, 0)));
        assertFalse(staticVector.equals(new Vector3(0, 0, 1)));
        assertFalse(staticVector.equals(new Vector3(1, 1, 1)));

        assertFalse(staticVector.equals(new WorldPosition(new Vector3(0, 0, 0))));
        assertFalse(staticVector.equals(null));
    }
}
