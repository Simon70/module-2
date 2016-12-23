package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends ss.week3.hotel.Safe implements Item {

    private double amount;

    //@ ensures this.getAmount() == amount;
    public PricedSafe(double amount) {
        super();
        this.amount = amount;
    }

    @Override
    //@ pure
    public double getAmount() {
        return amount;
    }

    @Override
    //@ pure
    public String toString() {
        return "" + amount;
    }

}
