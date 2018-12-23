package design_pattern.strategy_pattern;

public class HappyHourPrice implements Price {

	@Override
	public double getPrice(double price) {
		return price * 0.5;
	}

}
