package hr.fer.zemris.fuzzy.system;

import hr.fer.zemris.fuzzy.IFuzzySet;

public interface Defuzzifier {
	
	public int calculate(IFuzzySet set);
	
}
