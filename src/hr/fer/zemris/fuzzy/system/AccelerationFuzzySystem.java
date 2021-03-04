package hr.fer.zemris.fuzzy.system;

import java.util.ArrayList;
import java.util.List;

import hr.fer.zemris.fuzzy.*;

public class AccelerationFuzzySystem implements FuzzySystem {
	
	private RuleBase ruleBase;
	private Defuzzifier defuzzifier;
	
	public AccelerationFuzzySystem(Defuzzifier defuzz) {
		this.defuzzifier = defuzz;
		this.ruleBase = new AccelerationRuleBase();
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
