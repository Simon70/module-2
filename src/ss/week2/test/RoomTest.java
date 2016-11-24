package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;
import ss.week2.hotel.Safe;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        safe = new Safe();
        room = new Room(101, safe);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
}
