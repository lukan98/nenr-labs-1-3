package hr.fer.zemris.fuzzy.system;

import java.util.Arrays;

import hr.fer.zemris.fuzzy.IFuzzySet;

public class RudderRuleBase extends RuleBase{
	
	
	public RudderRuleBase() {
																// L, D, LK, DK, V, S
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{BoatSets.CRITICALLY_CLOSE_TO_SHORE, null, null, null, null, null}), BoatSets.SHARP_RIGHT));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, BoatSets.CRITICALLY_CLOSE_TO_SHORE, null, null, null, null}), BoatSets.SHARP_LEFT));
		
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{BoatSets.CLOSE_TO_SHORE, null, null, null, null, null}), BoatSets.EASY_RIGHT));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, BoatSets.CLOSE_TO_SHORE, null, null, null, null}), BoatSets.EASY_LEFT));
		
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, BoatSets.HEADING_TOWARDS_SHORE, null, null, null}), BoatSets.SHARP_RIGHT));
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, BoatSets.HEADING_TOWARDS_SHORE, null, null}), BoatSets.SHARP_LEFT));
		
		super.addRule(new Rule(Arrays.asList(new IFuzzySet[]{null, null, null, null, null, BoatSets.WRONG_WAY}), BoatSets.SHARP_RIGHT));
		
	}

}
