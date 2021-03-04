package hr.fer.zemris.fuzzy.demo.vjezba2;

import hr.fer.zemris.fuzzy.Domain;
import hr.fer.zemris.fuzzy.DomainElement;
import hr.fer.zemris.fuzzy.IDomain;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.MutableFuzzySet;
import hr.fer.zemris.fuzzy.Relations;

public class Primjer1 {
	public static void main(String[] args) {
		IDomain u = Domain.intRange(1, 6);  // {1,2,3,4,5}
		IDomain u2 = Domain.combine(u, u);
		
		IFuzzySet r1 = new MutableFuzzySet(u2)
				.set(DomainElement.of(new int[] {1,1}), 1)
				.set(DomainElement.of(new int[] {2,2}), 1)
				.set(DomainElement.of(new int[] {3,3}), 1)
				.set(DomainElement.of(new int[] {4,4}), 1)
				.set(DomainElement.of(new int[] {5,5}), 1)
				.set(DomainElement.of(new int[] {3,1}), 0.5)
				.set(DomainElement.of(new int[] {1,3}), 0.5);
		
		IFuzzySet r2 = new MutableFuzzySet(u2)
				.set(DomainElement.of(new int[] {1,1}), 1)
				.set(DomainElement.of(new int[] {2,2}), 1)
				.set(DomainElement.of(new int[] {3,3}), 1)
				.set(DomainElement.of(new int[] {4,4}), 1)
				.set(DomainElement.of(new int[] {5,5}), 1)
				.set(DomainElement.of(new int[] {3,1}), 0.5)
				.set(DomainElement.of(new int[] {1,3}), 0.1);
		
		IFuzzySet r3 = new MutableFuzzySet(u2)
				.set(DomainElement.of(new int[] {1,1}), 1)
				.set(DomainElement.of(new int[] {2,2}), 1)
				.set(DomainElement.of(new int[] {3,3}), 0.3)
				.set(DomainElement.of(new int[] {4,4}), 1)
				.set(DomainElement.of(new int[] {5,5}), 1)
				.set(DomainElement.of(new int[] {1,2}), 0.6)
				.set(DomainElement.of(new int[] {2,1}), 0.6)
				.set(DomainElement.of(new int[] {2,3}), 0.7)
				.set(DomainElement.of(new int[] {3,2}), 0.7)
				.set(DomainElement.of(new int[] {3,1}), 0.5)
				.set(DomainElement.of(new int[] {1,3}), 0.5);
		
		IFuzzySet r4 = new MutableFuzzySet(u2)
				.set(DomainElement.of(new int[] {1,1}), 1)
				.set(DomainElement.of(new int[] {2,2}), 1)
				.set(DomainElement.of(new int[] {3,3}), 1)
				.set(DomainElement.of(new int[] {4,4}), 1)
				.set(DomainElement.of(new int[] {5,5}), 1)
				.set(DomainElement.of(new int[] {1,2}), 0.4)
				.set(DomainElement.of(new int[] {2,1}), 0.4)
				.set(DomainElement.of(new int[] {2,3}), 0.5)
				.set(DomainElement.of(new int[] {3,2}), 0.5)
				.set(DomainElement.of(new int[] {1,3}), 0.4)
				.set(DomainElement.of(new int[] {3,1}), 0.4);
		
		boolean test1 = Relations.isUtimesUrelation(r1);
		System.out.println("r1 je definiran nad UxU? "+test1);
		
		boolean test2 = Relations.isSymmetric(r1);
		System.out.println("r1 je simetrična? "+test2);
		
		boolean test3 = Relations.isSymmetric(r2);
		System.out.println("r2 je simetrična? "+test3);
		
		boolean test4 = Relations.isReflexive(r1);
		System.out.println("r1 je refleksivna? "+test4);
		
		boolean test5 = Relations.isReflexive(r3);
		System.out.println("r3 je refleksivna? "+test5);
		
		boolean test6 = Relations.isMaxMinTransitive(r3);
		System.out.println("r3 je max-min tranzitivna? "+test6);
		
		boolean test7 = Relations.isMaxMinTransitive(r4);
		System.out.println("r4 je max-min tranzitivna? "+test7);
	}
}
