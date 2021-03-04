package hr.fer.zemris.fuzzy;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeDomain extends Domain {
	
	private SimpleDomain[] components;
	
	public CompositeDomain(SimpleDomain[] components) {
		this.components = components;
	}
	
	@Override
	public int getCardinality() {
		int cardinality = 1;
		
		for (SimpleDomain component : components) {
			cardinality *= component.getCardinality();
		}
		
		return cardinality;
	}

	@Override
	public IDomain getComponent(int index) {
		try {
			return components[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Kompozit nema toliko komponenata!");
		}
	}

	@Override
	public int getNumberOfComponents() {
		return components.length;
	}
	
	@Override
	public Iterator<DomainElement> iterator() {
		return new CompositeDomainIterator();
	}
	

	private class CompositeDomainIterator implements Iterator<DomainElement> {
		
		private ArrayList<Iterator<DomainElement>> iterators = new ArrayList<>();
		private int[] currentValues;
		private int currentIndex;
		
		public CompositeDomainIterator() {
			
			currentIndex = 0;
			
			for (SimpleDomain component : components) {
				iterators.add(component.iterator());
			}
			
			currentValues = new int[iterators.size()];
			
			for (Iterator<DomainElement> iterator : iterators) {
				currentValues[iterators.indexOf(iterator)] = iterator.next().getComponentValue(0);
			}
			
		}

		@Override
		public boolean hasNext() {
			return currentIndex < getCardinality();
		}

		@Override
		public DomainElement next() {
			if (currentIndex == 0) {
				currentIndex++;
				return new DomainElement(currentValues);
			}
			
			for (int i = getNumberOfComponents()-1; i>-1; i--) {
				
				if (iterators.get(i).hasNext()) {
					currentValues[i] = iterators.get(i).next().getComponentValue(0);
					break;
				} else {
					iterators.set(i, components[i].iterator());
					currentValues[i] = iterators.get(i).next().getComponentValue(0);
				}
				
			}
			currentIndex++;
			return new DomainElement(currentValues);
		}
		
	}
}
