package hr.fer.zemris.fuzzy;

public class HamacherTNorm implements IBinaryFunction{
	
	private double parameter;
	
	public HamacherTNorm(double parameter) {
		this.parameter = parameter;
	}

	@Override
	public double valueAt(double x, double y) {
		return (x*y)/(double)(parameter+(1-parameter)*(x+y-x*y));
	}

}
