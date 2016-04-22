package lab9;
/**
 *  @author Rakkan Tiasakul 5810546013
 *  This class is used for converting the unit.
 */

public class UnitConverter {
	public double convert (double amount, Unit fromUnit, Unit toUnit){
		/*
		 * @param getting the amount (in double) and the units (meter, centimeter, etc.) for converting
		 * @return return a number that is converted by multiply the amount to its unit then divide with another unit 
		 * that we want to know the value.
		 */
		return ((amount*fromUnit.getValue())/toUnit.getValue());
	}
	public Unit[] getUnits(){
		/* 
		 * @return return values from Length class.
		 */
		return Length.values();
		
	}
}
