package design_pattern.strategy_pattern;

public class NormalTimePrice implements Price {

	@Override
	public double getPrice(double price) {
		return price;
	}

}
