package hr.fer.zemris.fuzzy;

public class ZadehAnd implements IBinaryFunction {

	@Override
	public double valueAt(double x, double y) {
		return Double.min(x, y);
	}
	
}
