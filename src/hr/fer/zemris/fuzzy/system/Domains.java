package hr.fer.zemris.fuzzy.system;

import hr.fer.zemris.fuzzy.IDomain;
import hr.fer.zemris.fuzzy.SimpleDomain;

public class Domains {
	
	public static IDomain ANGLE = new SimpleDomain(-90, 91);
	
	public static IDomain ACCELERATION = new SimpleDomain(-30, 31);
	
	public static IDomain VELOCITY = new SimpleDomain(0, 101);
	
	public static IDomain DISTANCE = new SimpleDomain(0, 1301);
	
	public static IDomain DIRECTION = new SimpleDomain(0, 2);


}
