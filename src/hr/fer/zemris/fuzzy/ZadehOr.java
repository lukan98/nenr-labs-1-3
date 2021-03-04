package hr.fer.zemris.fuzzy;

public class ZadehOr implements IBinaryFunction {

	@Override
	public double valueAt(double x, double y) {
		return Double.max(x, y);
	}

}
