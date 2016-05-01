package lab9;

/**
 * @author Rakkan Tiasakul 5810546013
 * This is Length enum  that implements Unit Interface
 */

public enum Length implements Unit{

	/**
	 *  This part is using for setting names of units and the value of units.
	 * 
	 */
	METER("Meter", 1.0),
	FOOT("Foot",0.30480),
	CENTIMETER("Centimeter",0.01),
	KILOMETER("Kilometer", 1000.0),
	MILE("Mile",1609.344),
	WA("Wa",2.0),
	YARD("Yard",0.9144);

	/**
	 * public property for Length enum. It's immutable. 
	 */
	public final String name ;

	public final double value;

	/**
	 * @param to get name and value and set them.
	 */
	Length (String name, double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return to return the value after getting it.
	 */
	public double getValue(){
		return value;
	}
	/**
	 * @return to return name into String. 
	 */
	public String toString(){	 
		return name;
	}
}
