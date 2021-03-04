package hr.fer.zemris.fuzzy;

public class ZadehNot implements IUnaryFunction {

	@Override
	public double valueAt(double x) {
		return 1-x;
	}

}
