/**
 * Represents any integer number.
 * E.g. 0, -1, 2, etc.
 * 
 * @author Kameron Damaska
 */
public class IntegerN extends RationalN {
  
  /**
   * Constructs a newly allocated IntegerN object that represents the specified 
   * integer number.
   * 
   * @param integerN  The value to be represented by the NaturalN object.
   */
  public IntegerN(int integerN) {
    
    /* Sets the numerator equal to the parameter, and the denominator equal to
     * one
     */
    super(integerN, 1);
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
    
   /* Checks if the object is an IntegerN*/
    if(obj instanceof IntegerN) {
      
     /*Stores the object as an IntegerN*/
      IntegerN comparedIntegerN = (IntegerN)obj;
    
     /* Returns whether the values in both IntegerNs are equal*/
      return (this.getRealPart() == comparedIntegerN.getRealPart());
    }
   /* Returns false if the object is not an IntegerN*/
    else
      return false;
  }
  
}