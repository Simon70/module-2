package ss.week3.hotel;

/**
 * Created by simon on 28.11.16.
 */
public class PricedRoom extends ss.week3.hotel.Room implements Bill.Item {

	private double		roomPrice;
	private PricedSafe	pricedSafe;

	public PricedRoom(int roomID, double roomPrice, double safePrice) {
		super(roomID, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}

	@Override
	public double getAmount() {
		return roomPrice;
	}

	@Override
	public String toString() {
		return "" + roomPrice;
	}
}
