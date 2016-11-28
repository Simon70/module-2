package ss.week2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

public class RoomTest {
    private static final String NAME = "Jip";
    private static final int ROOM_NUMBER = 101;
    private Guest guest;
    private Room room;


    @Before
    public void setUp() {
        guest = new Guest(NAME);
        room = new Room(ROOM_NUMBER);
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        Assert.assertEquals(guest, room.getGuest());
    }

    @Test
    public void testNumber() {
        Assert.assertEquals(ROOM_NUMBER, room.getNumber());
    }

    @Test
    public void testSafeExistance() {
        Assert.assertNotNull(room.getSafe());
    }

    @Test
    public void testToString() {
        room.setGuest(guest);
        Assert.assertTrue(room.toString().contains(NAME));
        Assert.assertTrue(room.toString().contains(String.valueOf(ROOM_NUMBER)));
    }
}
