package ss.week3.hotel;

/**
 * Created by simon on 28.11.16.
 */
public class PricedRoom extends ss.week3.hotel.Room implements Bill.Item {

	private /*@ spec_public @*/ double	roomPrice;
	private PricedSafe						pricedSafe;

	//@ensures this.roomPrice == roomPrice;
	public PricedRoom(int roomID, double roomPrice, double safePrice) {
		super(roomID, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}

	@Override
	//@ pure
	public double getAmount() {
		return roomPrice;
	}

	@Override
	//@ pure
	public String toString() {
		return "" + roomPrice;
	}
}
