package ss.week3.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ss.week3.Password;
import ss.week3.hotel.Safe;

public class SafeTest {

    private Safe safe;

    @Before
    public void setUp() throws Exception {
        safe = new Safe();
    }

    @Test
    public void activate() {
        Assert.assertFalse("Safe is closed by default.", safe.isOpen());
        safe.activate("wrong password");
        Assert.assertFalse("Safe should not be activated with wrong password.", safe.isActive());

        safe.activate(Password.INITIAL);
        Assert.assertTrue("Safe should be activated with right password.", safe.isActive());

        //Deactivate while active.
        safe.deactivate();
        Assert.assertFalse("Safe should be deactivated.", safe.isActive());
        Assert.assertFalse("Safe should be closed.", safe.isOpen());

        //Deactivate while inactive.
        safe.deactivate();
        Assert.assertFalse("Safe should be deactivated again.", safe.isActive());
        Assert.assertFalse("Safe should be closed.", safe.isOpen());
    }

    @Test
    public void open() {
        Assert.assertFalse("Safe is closed by default,", safe.isOpen());
        Assert.assertFalse("Safe is inactive by default.", safe.isActive());

        safe.activate(Password.INITIAL);
        Assert.assertTrue("Safe should be activated.", safe.isActive());
        Assert.assertFalse("Safe should be closed.", safe.isOpen());

        safe.open("Wrong password");
        Assert.assertTrue("Safe should still be activated.", safe.isActive());
        Assert.assertFalse("Safe should still be closed.", safe.isOpen());

        //Try to open it while it's closed.
        safe.open(Password.INITIAL);
        Assert.assertTrue("Safe should still be activated.", safe.isActive());
        Assert.assertTrue("Safe should be opened.", safe.isOpen());

        //Try again while opened.
        safe.open(Password.INITIAL);
        Assert.assertTrue("Safe should still be activated.", safe.isActive());
        Assert.assertTrue("Safe should be opened.", safe.isOpen());

        //Close it
        safe.close();
        Assert.assertFalse("Safe should be closed.", safe.isOpen());
        Assert.assertTrue("Safe should still be activated.", safe.isActive());

        //Deactivate it.
        safe.deactivate();
        Assert.assertFalse("Safe should be closed.", safe.isOpen());
        Assert.assertFalse("Safe should be deactivated.", safe.isActive());

        //Try to open it while deactivated.
        safe.open(Password.INITIAL);
        Assert.assertFalse("Safe should still be deactivated.", safe.isActive());
        Assert.assertFalse("Safe should still be closed.", safe.isOpen());
    }

}
