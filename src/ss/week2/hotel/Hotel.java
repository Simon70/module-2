package ss.week2.hotel;

/**
 * Created by simon on 21.11.16.
 */
public class Hotel {

    private String name;
    private Room room0;
    private Room room1;

    public Hotel(String name) {
        this.name = name;
        this.room0 = new Room(1, new Safe());
        this.room1 = new Room(2, new Safe());
    }

    public Room checkIn(String password, String guestName) {
        Room room;
        if ((room = getFreeRoom()) == null)
            return null;
        room.getSafe().activate(password);
        if (!room.getSafe().isActive())
            return null;
        Guest guest = new Guest(guestName);
        guest.checkin(room);
        return room;
    }

    public void checkOut(String guestName) {
        Room room = getRoom(guestName);
        if (room != null) {
            room.getSafe().deactivate();
            room.getGuest().checkout();
        }
    }

    public Room getRoom(String guestName) {

        if (room0.getGuest() != null && room0.getGuest().getName().equals(guestName))
            return room0;
        if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName))
            return room1;
        return null;
    }

    public Password getPassword() {
        return new Password();
    }

    public Room getFreeRoom() {
        if (room0.getGuest() == null)
            return room0;
        if (room1.getGuest() == null)
            return room1;
        return null;
    }

    @Override
    public String toString() {
        return "Hotel: [Room 0=" + room0.toString() + ", Room 1=" + room1.toString() + "]";
    }
}
