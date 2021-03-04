package hr.fer.zemris.fuzzy;

import java.util.ArrayList;

public class Relations {
	
	public static boolean isUtimesUrelation(IFuzzySet relation) {
		IDomain domain = relation.getDomain();
		
		if(domain.getNumberOfComponents() != 2) return false;
		if(domain.getComponent(0).getCardinality() != domain.getComponent(1).getCardinality()) return false;
		
		for(int i=0; i<domain.getComponent(0).getCardinality(); i++) {
			if( !(domain.getComponent(0).elementForIndex(i).equals(domain.getComponent(1).elementForIndex(i))) ) return false;
		}
		
		return true;
	}
	
	public static boolean isSymmetric(IFuzzySet relation) {
		if (!isUtimesUrelation(relation)) return false;
		
		IDomain domain = relation.getDomain();
		
		int size = domain.getComponent(0).getCardinality();
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if (relation.getValueAt(domain.elementForIndex(i * size + j)) != relation.getValueAt(domain.elementForIndex(j * size +i)))
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean isReflexive(IFuzzySet relation) {
		if (!isUtimesUrelation(relation)) return false;
		
		IDomain domain = relation.getDomain();
		
		int size = domain.getComponent(0).getCardinality();
		
		for(int i=0; i<size; i++) {
			if (relation.getValueAt(domain.elementForIndex(i * (domain.getComponent(0).getCardinality() + 1))) != 1) return false;
		}
		
		return true;
	}
	
	public static boolean isMaxMinTransitive(IFuzzySet relation) {
		if (!isUtimesUrelation(relation)) return false;
		
		IDomain domain = relation.getDomain();
		
		int size = domain.getComponent(0).getCardinality();
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				DomainElement testingElement = domain.elementForIndex(i*size + j);
				ArrayList<DomainElement> minimums = new ArrayList<>();
				
				for(int k=0; k<size; k++) {
					if (k==i || k==j) continue;
					
					DomainElement element1 = domain.elementForIndex(i*size + k);
					DomainElement element2 = domain.elementForIndex(k*size + j);
					
					if (relation.getValueAt(element1) >= relation.getValueAt(element2)) minimums.add(element2);
					else minimums.add(element1);
					
				}
				
				DomainElement maximum = null;
				
				for (int m=0; m<minimums.size(); m++) {
					if (m==0) maximum = minimums.get(m);
					else if(relation.getValueAt(maximum) < relation.getValueAt(minimums.get(m))) {
						maximum = minimums.get(m);
					}
				}
				
				if (relation.getValueAt(testingElement) < relation.getValueAt(maximum)) return false;
			}
		}
		return true;
	}
	
	public static IFuzzySet compositionOfBinaryRelations(IFuzzySet relationA, IFuzzySet relationB) {
		if (relationA.getDomain().getNumberOfComponents()!=2 && relationB.getDomain().getNumberOfComponents()!=2) {
			throw new IllegalArgumentException("The parameter relations have to have exactly 2 components");
		}
		
		IDomain X, Y, Z, domainA, domainB;
		
		domainA = relationA.getDomain();
		domainB = relationB.getDomain();
		
		if (!isUtimesUrelation(new MutableFuzzySet(Domain.combine(domainA.getComponent(1), domainB.getComponent(0)))))
				throw new IllegalArgumentException("The domains of the relations have to be chained");
		
		X = relationA.getDomain().getComponent(0);
		Y = relationA.getDomain().getComponent(1);
		Z = relationA.getDomain().getComponent(0);
		
		MutableFuzzySet result = new MutableFuzzySet(Domain.combine(X, Z));
		
		for(int i=0; i<X.getCardinality(); i++) { // iterira po redovima A
			for(int j=0; j<Z.getCardinality(); j++) {  // iterira po stupcima B
				ArrayList<Double> minimums = new ArrayList<>();
				
				for(int k=0; k<Y.getCardinality(); k++) { // iterira po stupcima A, odnosno redovima B
					double valueA, valueB;
					
					valueA = relationA.getValueAt(domainA.elementForIndex(i*Y.getCardinality() + k));
					valueB = relationB.getValueAt(domainB.elementForIndex(k*Z.getCardinality() + j));
					
					minimums.add(Double.min(valueA, valueB));
				}
				
				double maximum = minimums.get(0);
				
				for (int m=0; m<minimums.size(); m++) {
					if(maximum < minimums.get(m)) {
						maximum = minimums.get(m);
					}
				}
				
				result.set(result.getDomain().elementForIndex(i*X.getCardinality() + j), maximum);
			}
		}
		
		return result;
	}

	public static boolean isFuzzyEquivalence(IFuzzySet relation) {
		return isSymmetric(relation) && isReflexive(relation) && isMaxMinTransitive(relation);
	}

}
