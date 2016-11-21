package ss.week1.ss.week1.hotel;

/**
 * Contains all information about a guest. Used in Rooms.
 *
 * @author Group 7
 */
public class Guest {

    private String name;
    private Room room;

    /**
     * Create a new guest with a name.
     *
     * @param name the name of the new quest.
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Return name of the quest.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return room of the quest.
     *
     * @return room.
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Checks the quest in at a room.
     *
     * @param room the room the quest will be checked in.
     * @return true if the room is not in use. False if it's in use.
     */
    public boolean checkin(Room room) {
        if (room.getGuest() == null) {
            //this room is not in use.
            room.setGuest(this);
            this.room = room;
            return true;
        }
        return false;
    }

    /**
     * Checks the quest out at a room.
     *
     * @return true if the quest was using a room. False if not.
     */
    public boolean checkout() {
        if (this.room == null) {
            return false;
        }
        this.room.setGuest(null);
        this.room = null;
        return true;
    }

    @Override
    public String toString() {
        return "Guest [name=" + name + "]";
    }
}
