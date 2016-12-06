package ss.week3.hotel;

public class BillItemBasic implements Bill.Item {

    private String description;
    private double amount;

    public BillItemBasic(String text, Double amount) {
        this.description = text;
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description;
    }
}
