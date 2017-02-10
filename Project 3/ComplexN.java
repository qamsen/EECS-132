/**
 * Represents any complex number. A complex number has a real part and imaginary
 * part.
 * E.g. 3.0 + 4.0i, 5.5 + 3.333333i, etc.
 * 
 * @author Kameron Damaska
 */
public class ComplexN extends Number {
  
  /**
   * Constructs a newly allocated ComplexN object that represents the specified 
   * complex number.
   * 
   * @param realPart       The value that represents the real part of the complex
    *                      number.
   * @param imaginaryPart  The value that represents the imaginary part of the
   *                       complex number.
   */
  public ComplexN(double realPart, double imaginaryPart) {
    
    /* Initializes the real and imaginary parts of the complex number*/
    super(realPart, imaginaryPart);
  }
  
  /**
   * Returns a String object representing this object's value.
   * 
   * @return  The value associated with this object as a String.
   */
  @Override
  public String toString() {
    
   /* The complex number as a StringBuilder*/
    StringBuilder ComplexN = new StringBuilder();
    
   /* Appends the real part of the complex numbr*/
    ComplexN.append(this.getRealPart());
    
    /* Appends a plus or a minus sign, depending on if the imaginary part is 
     * postive.
     */
    if (this.getImaginaryPart() < 0)
      ComplexN.append(" -");
    else
      ComplexN.append(" +");
    
    /* Appends the imaginary part of the complex number*/
    ComplexN.append(" " + Math.abs(this.getImaginaryPart()) + "i");
    
    /* Returns the complex number as a String*/
    return ComplexN.toString();
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
    
    /* Checks if the object to compare with is a ComplexN*/
    if(obj instanceof ComplexN) {
      
      /* Stores the object to compare with as a ComplexN*/
      ComplexN comparedComplex = (ComplexN)obj;
      
      /* Returns whether both real parts and imaginary parts are equal to 
       * eachother
       */
      return (this.getRealPart() == comparedComplex.getRealPart() &&
              this.getImaginaryPart() == comparedComplex.getImaginaryPart());
    }
    /* Returns false when the object is not a ComplexN*/
    else
      return false;
  }
  
}
