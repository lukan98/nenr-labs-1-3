package hr.fer.zemris.fuzzy.system;

import java.util.ArrayList;

public abstract class RuleBase {
	
	private ArrayList<Rule> rules;
	
	public RuleBase() {
		this.rules = new ArrayList<>();
	}
	
	public ArrayList<Rule> getRules() {
		return this.rules;
	}
	
	public void addRule(Rule rule) {
		this.rules.add(rule);
	}
	
}
