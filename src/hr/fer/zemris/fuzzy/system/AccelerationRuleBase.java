package hr.fer.zemris.fuzzy.system;

import java.util.Arrays;

import hr.fer.zemris.fuzzy.IFuzzySet;

public class AccelerationRuleBase extends RuleBase {
	
	public AccelerationRuleBase() {
															// L, D, LK, DK, V, S
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, null, BoatSets.TOO_SLOW, null}), BoatSets.ACCELERATE));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, null, BoatSets.TOO_FAST, null}), BoatSets.DECELERATE));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, null, BoatSets.VERY_NICE, null}), BoatSets.GREAT_SUCCESS));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, null, null, BoatSets.WRONG_WAY}), BoatSets.DECELERATE));
		
//		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{BoatSets.CRITICALLY_CLOSE_TO_SHORE, null, null, null, null, null}), BoatSets.ACCELERATE));
//		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, BoatSets.CRITICALLY_CLOSE_TO_SHORE, null, null, null, null}), BoatSets.ACCELERATE));
//		
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, BoatSets.HEADING_TOWARDS_SHORE, null, null, null}), BoatSets.DECELERATE));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, BoatSets.HEADING_TOWARDS_SHORE, null, null}), BoatSets.DECELERATE));
		
	}

}
