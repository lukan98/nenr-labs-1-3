package hr.fer.zemris.fuzzy;

public class LambdaFunction implements IIntUnaryFunction {
	private int alpha, beta, gamma;
	
	public LambdaFunction(int alpha, int beta, int gamma) {
		if (!(gamma > beta && beta > alpha)) throw new IllegalArgumentException("Gama mora biti veća od bete, a beta veća od alfe!");
		this.alpha = alpha;
		this.beta = beta;
		this.gamma = gamma;
	}

	@Override
	public double valueAt(int x) {	
		if (x>=alpha && x<beta) return (x-alpha)/(double)(beta-alpha);
		if (x>=beta && x<gamma) return (gamma-x)/(double)(gamma-beta);
		else return 0;
	}

}
