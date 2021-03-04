package hr.fer.zemris.fuzzy;

import java.util.Arrays;

public class DomainElement {
	private int[] values;
	
	public DomainElement(int[] values) {
		this.values = values;
	}
	
	public int getNumberOfComponents() {
		return values.length;
	}
	
	public int getComponentValue(int index) {
		try {
			return values[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Domain element does not contain enough components!");
		}
	}
	
	public static DomainElement of(int[] values) {
		return new DomainElement(values);
	}

	@Override
	public String toString() {
		return Arrays.toString(values).replace("[", "").replace("]", "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainElement other = (DomainElement) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}
}
