package hr.fer.zemris.fuzzy;

public class Operations {
	
	public static IFuzzySet unaryOperation(IFuzzySet fuzzySet, IUnaryFunction function) {
		MutableFuzzySet resultSet = new MutableFuzzySet(fuzzySet.getDomain());
		
		for (DomainElement element : fuzzySet.getDomain()) {
			resultSet = resultSet.set(element, function.valueAt(fuzzySet.getValueAt(element)));
		}
		
		return resultSet;
	}
	
	public static IFuzzySet binaryOperation(IFuzzySet fuzzySetA, IFuzzySet fuzzySetB, IBinaryFunction function) {
		if (!fuzzySetA.getDomain().equals(fuzzySetB.getDomain())) throw new IllegalArgumentException("Domene neizrazitih skupova moraju biti jednake!");
		
		MutableFuzzySet resultSet = new MutableFuzzySet(fuzzySetA.getDomain());
		
		for (DomainElement element : fuzzySetA.getDomain()) {
			resultSet = resultSet.set(element, function.valueAt(fuzzySetA.getValueAt(element), fuzzySetB.getValueAt(element)));
		}
		
		return resultSet;
	}
	
	public static IUnaryFunction zadehNot() {
		return new ZadehNot();
	}
	
	public static IBinaryFunction zadehAnd() {
		return new ZadehAnd();
	}
	
	
	public static IBinaryFunction zadehOr() {
		return new ZadehOr();
	}
	
	
	public static IBinaryFunction hamacherTNorm(double parameter) {
		return new HamacherTNorm(parameter);
	}
	
	
	public static IBinaryFunction hamacherSNorm(double parameter) {
		return new HamacherSNorm(parameter);
	}

}
