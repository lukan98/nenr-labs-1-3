package hr.fer.zemris.fuzzy.system;

import hr.fer.zemris.fuzzy.CalculatedFuzzySet;
import hr.fer.zemris.fuzzy.IFuzzySet;
import hr.fer.zemris.fuzzy.StandardFuzzySets;

public class BoatSets {
	
	//decisions
		//turning
		public static IFuzzySet EASY_RIGHT = new CalculatedFuzzySet(Domains.ANGLE, StandardFuzzySets.lambdaFunction(50, 60, 65));
		public static IFuzzySet EASY_LEFT = new CalculatedFuzzySet(Domains.ANGLE, StandardFuzzySets.lambdaFunction(115, 120, 130));
		public static IFuzzySet SHARP_RIGHT = new CalculatedFuzzySet(Domains.ANGLE, StandardFuzzySets.lFunction(0, 20));
		public static IFuzzySet SHARP_LEFT = new CalculatedFuzzySet(Domains.ANGLE, StandardFuzzySets.gammaFunction(180, 160));;
		//wrong way
		public static IFuzzySet TURN_AROUND = new CalculatedFuzzySet(Domains.ANGLE, StandardFuzzySets.gammaFunction(175, 165));
		
		//acceleration
		public static IFuzzySet ACCELERATE = new CalculatedFuzzySet(Domains.ACCELERATION, StandardFuzzySets.gammaFunction(20, 10));
		public static IFuzzySet DECELERATE = new CalculatedFuzzySet(Domains.ACCELERATION, StandardFuzzySets.lFunction(-30, -20));
		public static IFuzzySet GREAT_SUCCESS = new CalculatedFuzzySet(Domains.ACCELERATION, StandardFuzzySets.lambdaFunction(-3, 0, 3));
		
	//information
		//spatial location
		public static IFuzzySet HEADING_TOWARDS_SHORE = new CalculatedFuzzySet(Domains.DISTANCE, StandardFuzzySets.lFunction(60, 80));
		public static IFuzzySet CRITICALLY_CLOSE_TO_SHORE = new CalculatedFuzzySet(Domains.DISTANCE, StandardFuzzySets.lFunction(25, 30));
		public static IFuzzySet CLOSE_TO_SHORE = new CalculatedFuzzySet(Domains.DISTANCE, StandardFuzzySets.lambdaFunction(25, 40, 45));
		public static IFuzzySet WRONG_WAY = new CalculatedFuzzySet(Domains.DIRECTION, StandardFuzzySets.lFunction(0, 1));
		
		//velocity
		public static IFuzzySet TOO_SLOW = new CalculatedFuzzySet(Domains.VELOCITY, StandardFuzzySets.lFunction(30, 55));
		public static IFuzzySet TOO_FAST = new CalculatedFuzzySet(Domains.VELOCITY, StandardFuzzySets.gammaFunction(70, 65));
		public static IFuzzySet VERY_NICE = new CalculatedFuzzySet(Domains.VELOCITY, StandardFuzzySets.lambdaFunction(50, 60, 70));
}
