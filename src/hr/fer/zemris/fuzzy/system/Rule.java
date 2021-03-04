package hr.fer.zemris.fuzzy.system;

import java.util.ArrayList;
import java.util.Collection;

import hr.fer.zemris.fuzzy.*;

public class Rule {

	private ArrayList<IFuzzySet> antecedents; // poredani istim indeksima kao i ulazne vrijednosti
	private IFuzzySet consequence;
	
	public Rule(Collection<IFuzzySet> antecedents, IFuzzySet consequence) {
		this.antecedents = new ArrayList<>(antecedents);
		this.consequence = consequence;
	}
	
	public IFuzzySet minimumEvaluate(int[] values) {
		double mi = 1.0;
		
		IBinaryFunction operation = Operations.zadehAnd();
		
		for(int i=0; i<this.antecedents.size(); i++) {
			if ( !(antecedents.get(i) == null) ) {
				mi = operation.valueAt(mi, antecedents.get(i).getValueAt(DomainElement.of(new int[] {values[i]})));
			}
		}
		
		return consequence.scale(mi);
	}
	
	public IFuzzySet productEvaluate(int[] values) {
		double mi = 1.0;
		
		for(int i=0; i<this.antecedents.size(); i++) {
			if ( !(antecedents.get(i) == null) ) {
				mi *= antecedents.get(i).getValueAt(DomainElement.of(new int[] {values[i]}));
			}
		}
		
		return consequence.scale(mi);
	}
	
}
