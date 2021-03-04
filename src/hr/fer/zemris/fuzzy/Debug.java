package hr.fer.zemris.fuzzy;

public class Debug {

	public static void print(IDomain domain, String headingText) { 
		if(headingText!=null) {
			System.out.println(headingText);
		}
		for(DomainElement e : domain) {
			System.out.println("Element domene: " + e);
		}
		System.out.println("Kardinalitet domene je: " + domain.getCardinality());
		System.out.println();
	}
	
	
    public static void print(IFuzzySet set, String headingText) {
        if (headingText != null) {
            System.out.println(headingText);
        }

        for (var e : set.getDomain()) {
            System.out.printf("d(%d)=%6f\n", e.getComponentValue(0), set.getValueAt(e));
        }

        System.out.println();
    }

}
