package hr.fer.zemris.fuzzy;

import java.util.NoSuchElementException;

public class MutableFuzzySet implements IFuzzySet {
	
	private double[] memberships;
	private IDomain domain;
	
	public MutableFuzzySet(IDomain domain) {
		this.domain = domain;
		this.memberships = new double[domain.getCardinality()];
	}

	@Override
	public IDomain getDomain() {
		return this.domain;
	}

	@Override
	public double getValueAt(DomainElement element) {
		if (domain.indexOfElement(element)==-1) throw new NoSuchElementException("Nema trazenog elementa u domeni!");
		
		return memberships[domain.indexOfElement(element)];
	}
	
	public MutableFuzzySet set(DomainElement element, double value) {
		if (domain.indexOfElement(element)==-1) throw new NoSuchElementException("Nema trazenog elementa u domeni!");
		this.memberships[domain.indexOfElement(element)]=value;
		return this;
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
