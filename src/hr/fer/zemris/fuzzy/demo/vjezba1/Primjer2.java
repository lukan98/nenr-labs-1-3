package hr.fer.zemris.fuzzy.demo.vjezba1;

import hr.fer.zemris.fuzzy.Debug;
import hr.fer.zemris.fuzzy.Domain;
import hr.fer.zemris.fuzzy.DomainElement;
import hr.fer.zemris.fuzzy.IDomain;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.MutableFuzzySet;
import hr.fer.zemris.fuzzy.Operations;

public class Primjer2 {
	public static void main(String[] args) {
		IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
		IFuzzySet set1 = new MutableFuzzySet(d).set(DomainElement.of(new int[] {0}), 1.0)
											   .set(DomainElement.of(new int[] {1}), 0.8)
											   .set(DomainElement.of(new int[] {2}), 0.6)
											   .set(DomainElement.of(new int[] {3}), 0.4)
											   .set(DomainElement.of(new int[] {4}), 0.2);
		Debug.print(set1, "Set1:");
		IFuzzySet notSet1 = Operations.unaryOperation(set1, Operations.zadehNot());
		Debug.print(notSet1, "notSet1:");
		IFuzzySet union = Operations.binaryOperation(set1, notSet1, Operations.zadehOr());
		Debug.print(union, "Set1 union notSet1:");
		IFuzzySet hinters = Operations.binaryOperation(set1, notSet1, Operations.hamacherTNorm(1.0));
		Debug.print(hinters, "Set1 intersection with notSet1 using parameterised Hamacher T norm with parameter 1.0:");
} }