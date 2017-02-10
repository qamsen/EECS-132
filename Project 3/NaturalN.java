/**
 * Represents any natural number. A natural number is any non-negative integer.
 * E.g. 0, 2, 3, etc.
 * 
 * @author Kameron Damaska
 */
public class NaturalN extends IntegerN {
   
  /**
   * Constructs a newly allocated NaturalN object that represents the specified 
   * natural number.
   * 
   * @param naturalN              The value to be represented by the NaturalN 
   *                              object.
   * @throws ArithmeticException  If value is negative
   */
  public NaturalN(int naturalN) throws ArithmeticException {
    
    /*Initializes the natural number*/
    super(naturalN);
    
    /* Throws an ArithmeticException if value is not a natural number (less than 
     * 0).
     */
    if(naturalN < 0)
      throw new ArithmeticException(naturalN + " "+  "is not a natural number!");
  }
  
  /**
   * Compares this object to the specified object.
   * 
   * @param obj  The object to compare with.
   * @return     true if values associated with the objects are the same,
   *             false otherwise.
   */
  public boolean equals(Object obj) {
    
    /* Checks if the object is a NaturalN*/
    if(obj instanceof NaturalN) {
      
      /* The NaturalN this NaturalN is being compared to*/
      NaturalN comparedNaturalN = (NaturalN)obj;
      
      /* Returns whether the two values are equal*/
      return (this.getRealPart() == comparedNaturalN.getRealPart());
    }
    /* Returns false when the object is not an IntegerN*/
    else
      return false;
  }
  
}