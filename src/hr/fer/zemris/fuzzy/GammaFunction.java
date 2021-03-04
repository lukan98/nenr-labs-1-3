package hr.fer.zemris.fuzzy;

public class GammaFunction implements IIntUnaryFunction {

	private int alpha, beta;
	
	public GammaFunction(int alpha, int beta) {
		if (beta >= alpha) throw new IllegalArgumentException("Beta mora biti isključivo manja od alfe!");
		this.alpha = alpha;
		this.beta = beta;
	}

	@Override
	public double valueAt(int x) {
		if (x < alpha) return 0;
		if (x >= beta) return 1;
		else {
			return (x-alpha)/(double)(beta-alpha);
		}
	}

}
