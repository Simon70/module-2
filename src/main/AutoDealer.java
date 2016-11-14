package main;

public class AutoDealer extends Car{
	public AutoDealer(float price, int distributionTimes) {
		super(price);
		this.distributionTimes = distributionTimes;
	}

	private int distributionTimes;
}
