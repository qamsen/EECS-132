/**
 * Serves as a framework for any number
 * 
 * @author Kameron Damaska
 */
public abstract class Number {
  
  /* The real value of a number*/
  final private double realPart;

  /* The imaginary value of a number*/
  final private double imaginaryPart;
  
  /**
   * Constructs a newly allocated object that represents the speccified
   * number.
   * 
   * @param realPart       The value associated with the real part of the number.
   * @param imaginaryPart  The value associated with the imaginary part of the 
   *                       number.
   */
  public Number(double realPart, double imaginaryPart) {
    
    /* Initializes the real and imaginary values of the number*/
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }
  
  /**
   * Returns the real number portion of the number.
   * 
   * @return  The real part of the number.
   */
  public double getRealPart() {
    /* Returns the real part of the complex number*/
    return realPart;
  }
  
  /**
   * Returns the imaginary number portion of the number.
   * 
   * @return  The imaginary part of the number.
   */
  public double getImaginaryPart() {
    /* Returns the imaginary part of the complex number*/
    return imaginaryPart;
  }
  
  /**
   * Returns this object as a String
   * 
   * @return  This object as a String
   */
  @Override
  public abstract String toString();
  
  /**
   * Compares this Number to the the Object parameter.
   * 
   * @param obj  The object used for comparison
   * @return     True if equal, false otherwise
   */
  @Override
  public abstract boolean equals(Object obj);
  
}