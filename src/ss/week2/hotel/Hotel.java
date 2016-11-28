package ss.week2.hotel;

/**
 * Created by simon on 21.11.16.
 */
public class Hotel {

    private String name;
    private Room room0;
    private Room room1;
    private Password password;

    //@ requires name != null
    //@ ensures this.room0 != null;
    //@ ensures this.room1 != null;
    //@ ensures this.getName() == name;
    //@ ensures this.getPassword() != null;
    public Hotel(String name) {
        assert name != null && !name.isEmpty() : "Parameter name may not be null.";
        this.name = name;
        this.room0 = new Room(1);
        this.room1 = new Room(2);
        password = new Password();
    }

    //@ requires password != null;
    //@ requires guestName != null;
    public Room checkIn(String password, String guestName) {
        assert password != null && !password.isEmpty() : "Parameter password may not be null.";
        assert guestName != null && !guestName.isEmpty() : "Parameter guestName may not be null.";
        Room room;
        if ((room = getFreeRoom()) == null) {
            return null;
        }
        room.getSafe().activate(password);
        if (!room.getSafe().isActive())
            return null;
        if (room0.getGuest() != null && room0.getGuest().getName().equals(guestName))
            return null;
        if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName))
            return null;
        Guest guest = new Guest(guestName);
        guest.checkin(room);
        return room;
    }

    //@ requires guestName != null;
    //@ ensures \old(getRoom(guestName)) != null ==> \old(getRoom).getSafe().isActive() == false;
    public void checkOut(String guestName) {
        assert guestName != null && !guestName.isEmpty() : "Parameter guestName may not be null.";
        Room room = getRoom(guestName);
        if (room != null) {
            room.getSafe().deactivate();
            room.getGuest().checkout();
        }
    }


    //@ requires guestName != null;
    //@ pure
    public Room getRoom(String guestName) {
        assert guestName != null && !guestName.isEmpty() : "Parameter guestName may not be null.";
        if (room0.getGuest() != null && room0.getGuest().getName().equals(guestName)) {
            return room0;
        }
        if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName)) {
            return room1;
        }
        return null;
    }

    //@ pure
    public Password getPassword() {
        return password;
    }

    //@ pure
    public String getName() {
        return name;
    }

    //@ pure
    public Room getFreeRoom() {
        if (room0.getGuest() == null) {
            return room0;
        }
        if (room1.getGuest() == null) {
            return room1;
        }
        return null;
    }

    //@ pure
    @Override
    public String toString() {
        return "Hotel: [Room 0=" + room0.toString() + ", Room 1=" + room1.toString() + "]";
    }
}
