/**
 * Represents any real number.
 * E.g. 0.1, -1.0, 2.9, etc.
 * 
 * @author Kameron Damaska
 */
public class RealN extends ComplexN {
  
  /**
   * Constructs a newly allocated RealN object that represents the specified 
   * real number.
   * 
   * @param realN  The value to be represented by the RealN object.
   */ 
  public RealN(double realN) {
    
    /* Sets real part of the number equal to the parameter, and the imaginary 
     * part to 0*/
    super(realN, 0);
  }
  
  /**
   * Returns a String object representing this object's value.
   * 
   * @return  The value associated with this object
   */
  @Override
  public String toString() {
    /* Returns the RealN as a String*/
    return Double.toString(this.getRealPart());
  }
  
  /**
   * Compares this object to the specified object.
   * 
   * @param obj  The object to compare with.
   * @return     true if values associated with the objects are the same,
   *             false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    
   /* Checks if the object is a RealN*/
    if(obj instanceof RealN) {
      
     /* Stores the object as a RealN*/
      RealN comparedRealN = (RealN)obj;
      
     /* Returns whether the values in both RealNs are equal*/
      return (this.getRealPart() == comparedRealN.getRealPart());
    }
   /* Returns false when the parameter is not a RealN*/
    else
      return false;
  }
  
}