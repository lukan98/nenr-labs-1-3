package hr.fer.zemris.fuzzy;

public class LFunction implements IIntUnaryFunction {
	
	private int alpha, beta;
	
	public LFunction(int alpha, int beta) {
		if (alpha >= beta) throw new IllegalArgumentException("Alfa mora biti isključivo manja od bete!");
		this.alpha = alpha;
		this.beta = beta;
	}

	@Override
	public double valueAt(int x) {
		if (x < alpha) return 1;
		if (x >= beta) return 0;
		else {
			return (beta-x)/(double)(beta-alpha);
		}
	}

}
