package hr.fer.zemris.fuzzy;

public interface IFuzzySet {
	
	public IDomain getDomain();
	
	public double getValueAt(DomainElement element);
	
	public IFuzzySet clip(double mi);
	
	public IFuzzySet scale(double mi);
	
}
