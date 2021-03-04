package hr.fer.zemris.fuzzy;

public class StandardFuzzySets {
	
	public static IIntUnaryFunction lFunction(int alpha, int beta) {
		return new LFunction(alpha, beta);
	}
	
	public static IIntUnaryFunction gammaFunction(int alpha, int beta) {
		return new GammaFunction(alpha, beta);
	}

	public static IIntUnaryFunction lambdaFunction(int alpha, int beta, int gamma) {
		return new LambdaFunction(alpha, beta, gamma);
	}

}
