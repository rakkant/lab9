package lab9;

/*
 * This is Length enum  that implements Unit Interface
 */

public enum Length implements Unit{

/*	
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
	
	/*
	 * public property for Length enum. It's immutable. 
	 */
	public final String name ;
	public final double value;
	
	Length (String name, double value){
	/*
	 * @param to get name and value and set them.
	 */
		this.name = name;
		this.value = value;
	}
	 public double getValue(){
	/*
	 * @return to return the value after getting it.
	 */
		 return value;
	 }
	 public String toString(){	 
	/*
	 * @return to return name into String. 
	 */
		 return name;
	 }
}
