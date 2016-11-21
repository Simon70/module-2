package ss.week2.hotel;

/**
 * Hotel room with number and possibly a guest.
 *
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private Safe safe;
    private int number;
    private Guest guest;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     *
     * @param number number of the new <code>Room</code>
     * @param safe safe that belongs to this <code>Room</code>
     */
    public Room(int number, Safe safe) {
        this.number = number;
        this.safe = safe;
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Room [number=" + number + "]";
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     *
     * @return the guest of this <code>Room</code>;
     * <code>null</code> if this <code>Room</code>
     * is not currently rented
     */
    public Guest getGuest() {
        return guest;
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     *
     * @param g the next guest renting this <code>Room</code>;
     *          if <code>null</code> is passed, this <code>Room</code>
     *          is empty afterwards
     */
    public void setGuest(Guest g) {
        guest = g;
    }


    public Safe getSafe() {
        return safe;
    }
}
