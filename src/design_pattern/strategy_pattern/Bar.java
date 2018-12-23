package design_pattern.strategy_pattern;

public class Bar {

	Price price;
	
	public Bar(Price price) {
		this.price = price;
	}
	
	public double getPrice(double p) {
		return price.getPrice(p);
	}
}
