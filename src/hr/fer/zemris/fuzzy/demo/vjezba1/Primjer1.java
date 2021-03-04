package hr.fer.zemris.fuzzy.demo.vjezba1;

import hr.fer.zemris.fuzzy.CalculatedFuzzySet;
import hr.fer.zemris.fuzzy.Debug;
import hr.fer.zemris.fuzzy.Domain;
import hr.fer.zemris.fuzzy.DomainElement;
import hr.fer.zemris.fuzzy.IDomain;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.MutableFuzzySet;
import hr.fer.zemris.fuzzy.StandardFuzzySets;

public class Primjer1 {
	
	public static void main(String[] args) {
		
		IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
		IFuzzySet set1 = new MutableFuzzySet(d).set(DomainElement.of(new int[] {0}), 1.0)
											   .set(DomainElement.of(new int[] {1}), 0.8)
											   .set(DomainElement.of(new int[] {2}), 0.6)
											   .set(DomainElement.of(new int[] {3}), 0.4)
											   .set(DomainElement.of(new int[] {4}), 0.2);
		Debug.print(set1, "Set1:");
 
		IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
		IFuzzySet set2 = new CalculatedFuzzySet(
				d2,
				StandardFuzzySets.lambdaFunction(
						d2.indexOfElement(DomainElement.of(new int[] {-4})),
						d2.indexOfElement(DomainElement.of(new int[] {0})),
						d2.indexOfElement(DomainElement.of(new int[] {4}))
						)
				);
		Debug.print(set2, "Set2:");
	}
}
