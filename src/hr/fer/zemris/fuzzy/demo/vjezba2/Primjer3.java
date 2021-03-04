package hr.fer.zemris.fuzzy.demo.vjezba2;

import hr.fer.zemris.fuzzy.Domain;
import hr.fer.zemris.fuzzy.DomainElement;
import hr.fer.zemris.fuzzy.IDomain;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.MutableFuzzySet;
import hr.fer.zemris.fuzzy.Relations;

public class Primjer3 {
	
	public static void main(String[] args) {
		IDomain u = Domain.intRange(1, 4);  // {1,2,3,4}
		
		IFuzzySet r = new MutableFuzzySet(Domain.combine(u, u))
				.set(DomainElement.of(new int[] {1,1}), 1)
				.set(DomainElement.of(new int[] {1,2}), 0.6)
				.set(DomainElement.of(new int[] {1,3}), 0.4)
				.set(DomainElement.of(new int[] {2,1}), 0.6)
				.set(DomainElement.of(new int[] {2,2}), 1)
				.set(DomainElement.of(new int[] {2,3}), 0.3)
				.set(DomainElement.of(new int[] {3,1}), 0.4)
				.set(DomainElement.of(new int[] {3,2}), 0.3)
				.set(DomainElement.of(new int[] {3,3}), 1);
		
		IFuzzySet r2 = r;
		
		System.out.println( "Početna relacija je neizrazita relacija ekvivalencije? " + Relations.isFuzzyEquivalence(r2)); 
		System.out.println();
		
		for(int i = 1; i <= 3; i++) {
			r2 = Relations.compositionOfBinaryRelations(r2, r);
			System.out.println( "Broj odrađenih kompozicija: " + i + ". Relacija je:");
			for(DomainElement e : r2.getDomain()) {
				System.out.println("mu("+e+")="+r2.getValueAt(e));
			}
			
			System.out.println( "Ova relacija je neizrazita relacija ekvivalencije? " + Relations.isFuzzyEquivalence(r2));
			System.out.println();
		}
	}

}
