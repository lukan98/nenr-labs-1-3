package hr.fer.zemris.fuzzy;

public class CalculatedFuzzySet implements IFuzzySet {
	
	private IDomain domain;
	private IIntUnaryFunction function;
	
	public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
		this.domain = domain;
		this.function = function;
	}

	@Override
	public IDomain getDomain() {
		return this.domain;
	}

	@Override
	public double getValueAt(DomainElement element) {
		return this.function.valueAt(domain.indexOfElement(element));
	}
	
	@Override
	public IFuzzySet clip(double mi) {
		MutableFuzzySet clippedSet = new MutableFuzzySet(this.domain);
		
		for (DomainElement element : this.domain) {
			if (this.getValueAt(element) > mi)
				clippedSet.set(element, mi);
			else
				clippedSet.set(element, this.getValueAt(element));
		}
		
		return clippedSet;
	}

	@Override
	public IFuzzySet scale(double mi) {
		MutableFuzzySet scaledSet = new MutableFuzzySet(this.domain);
		
		for (DomainElement element : this.domain) {
			scaledSet.set(element, this.getValueAt(element)*mi);
		}
		
		return scaledSet;
	}

}
