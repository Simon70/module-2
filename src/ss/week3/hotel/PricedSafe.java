package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends ss.week3.hotel.Safe implements Item {

	private double amount;

	public PricedSafe(double amount) {
		this.amount = amount;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "" + amount;
	}

}
