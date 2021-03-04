package hr.fer.zemris.fuzzy;

public class HamacherSNorm implements IBinaryFunction{
	
	private double parameter;
	
	public HamacherSNorm(double parameter) {
		this.parameter = parameter;
	}

	@Override
	public double valueAt(double x, double y) {
		return (x+y-(2-parameter)*x*y)/(double)(1-(1-parameter)*x*y);
	}


}
