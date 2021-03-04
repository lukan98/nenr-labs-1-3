package hr.fer.zemris.fuzzy.system;

import java.util.ArrayList;
import java.util.List;

import hr.fer.zemris.fuzzy.IBinaryFunction;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.Operations;
import hr.fer.zemris.fuzzy.ZadehOr;

public class RudderFuzzySystem implements FuzzySystem {
	
	private RuleBase ruleBase;
	private Defuzzifier defuzzifier;
	
	public RudderFuzzySystem(Defuzzifier defuzz) {
		this.defuzzifier = defuzz;
		this.ruleBase = new RudderRuleBase();
	}
	
	// L, D, LK, DK, V, S
	
	@Override
	public int determineMin(int[] values) {
		List<IFuzzySet> conclusions = new ArrayList<>();
		ArrayList<Rule> rules = ruleBase.getRules();
		
		for (Rule rule : rules) {
			conclusions.add(rule.minimumEvaluate(values));
		}
		
		IFuzzySet conclusionUnion = conclusions.get(0);
		
		IBinaryFunction or = new ZadehOr();
		
		for (int i=1; i<conclusions.size(); i++) {
			conclusionUnion = Operations.binaryOperation(conclusionUnion, conclusions.get(i), or);
		}
		
		return this.defuzzifier.calculate(conclusionUnion);
	}

	@Override
	public int determineProd(int[] values) {
		List<IFuzzySet> conclusions = new ArrayList<>();
		ArrayList<Rule> rules = ruleBase.getRules();
		
		for (Rule rule : rules) {
			conclusions.add(rule.minimumEvaluate(values));
		}
		
		IFuzzySet conclusionUnion = conclusions.get(0);
		
		IBinaryFunction or = new ZadehOr();
		
		for (int i=1; i<conclusions.size(); i++) {
			conclusionUnion = Operations.binaryOperation(conclusionUnion, conclusions.get(i), or);
		}
		
		return this.defuzzifier.calculate(conclusionUnion);
	}

}
