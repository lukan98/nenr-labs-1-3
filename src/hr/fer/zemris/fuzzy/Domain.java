package hr.fer.zemris.fuzzy;

import java.util.Iterator;

public abstract class Domain implements IDomain {
	
	public static IDomain intRange(int first, int last) {
		return new SimpleDomain(first, last);
	}
	
	public static IDomain combine(IDomain firstDomain, IDomain secondDomain) {
		return new CompositeDomain(new SimpleDomain[] {(SimpleDomain) firstDomain, (SimpleDomain) secondDomain});
	}

	@Override
	public int indexOfElement(DomainElement element) {
		int currentIndex = 0;
		Iterator<DomainElement> iterator = this.iterator();
		
		while (currentIndex < this.getCardinality()) {
			if (iterator.next().equals(element)) return currentIndex;
			else currentIndex++;
		}
		
		return -1;
	}

	@Override
	public DomainElement elementForIndex(int index) {
		int currentIndex = -1;
		Iterator<DomainElement> iterator = this.iterator();
		
		while (currentIndex < index && iterator.hasNext()) {
			currentIndex++;
			if (currentIndex == index) return iterator.next();
			else iterator.next();
		}
		
		return null;
	}

}
