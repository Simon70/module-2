package main;

public class AutoDealer extends Car {

	public AutoDealer(float price, int distributionTimes, Person latestOwner, Manufacturer manufacturer) {
		super(price, manufacturer);
		this.distributionTimes = distributionTimes;
		this.latestOwner = latestOwner;
	}

	private int		distributionTimes;
	private Person	latestOwner;
}
