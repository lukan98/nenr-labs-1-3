package hr.fer.zemris.fuzzy.system;

import hr.fer.zemris.fuzzy.DomainElement;
import hr.fer.zemris.fuzzy.IFuzzySet;

public class CoADefuzzifier implements Defuzzifier {

	@Override
	public int calculate(IFuzzySet set) {
		double sumA = 0;
		double sumB = 0;
	
		for (DomainElement element : set.getDomain()) {
			sumA += set.getValueAt(element)*element.getComponentValue(0);
			sumB += set.getValueAt(element);
		}
		
		return (int)(sumA/sumB);
	}

}
