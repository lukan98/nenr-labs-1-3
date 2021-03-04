package hr.fer.zemris.fuzzy;

import java.util.Iterator;

public class SimpleDomain extends Domain{
	
	private int first, last; // lower bound is inclusive, upper bound is exclusive
	
	public SimpleDomain(int first, int last) {
		this.first = first;
		this.last = last;
	}

	@Override
	public int getCardinality() {
		return last-first;
	}

	@Override
	public IDomain getComponent(int index) {
		return this;
	}

	@Override
	public int getNumberOfComponents() {
		return 1;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return last;
	}
	
	@Override
	public Iterator<DomainElement> iterator() {
		return new SimpleDomainIterator();
	}
	
	private class SimpleDomainIterator implements Iterator<DomainElement> {
		
		private int current = first;

		@Override
		public boolean hasNext() {
			return current < last;
		}

		@Override
		public DomainElement next() {
			return new DomainElement(new int[] {current++});
		}
	}

}
