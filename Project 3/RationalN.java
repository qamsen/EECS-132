/**
 * Represents any rational number. A rational number has integers for numerator
 * and denominator.
 * E.g. 3/4, 5/2, etc.
 * 
 * @author Kameron Damaska
 */
public class RationalN extends RealN {
  
  /* The numerator of the rational number*/
  final private int numerator;
  
  /* The denominator of the rational number*/
  final private int denominator;
  
  /**
   * Constructs a newly allocated RationalN object that represents the specified
   * rational number.
   * 
   * @param numerator    The value of the numerator.
   * @param denominator  The value of the denominator.
   */ 
  public RationalN(int numerator, int denominator) {
    
    /* Assigns the real part of the number to the decimal equivalent of the
     * rational number.
     */
    super((double)numerator / (double)denominator);
    
    /* Initializes the numerator and denominator*/
    this.numerator = numerator;
    this.denominator = denominator;
    
    /*Divide by 0 error*/
    if(denominator == 0)
      throw new ArithmeticException("Can't divide by 0!");
  }
  
  /** 
   * Returns the rational number's numerator.
   * 
   * @return  The numerator of the rational number.
   */
  public int getNumerator() {
    /* Returns the numerator*/
    return this.numerator;
  }

  /** 
   * Returns the rational number's denominator.
   * 
   * @return  The denominator of the rational number.
   */
  public int getDenominator() {
    /*Returns the denominator*/
    return this.denominator;
  }
  
  /** 
   * Returns an int whose value is the greatest common divisor of the numerator
   * and denominator
   * 
   * @return  The great common divisor of numerator and denominator
   */
  private int findGCD() {
    
    /*The numerator*/ 
    int int1 = this.getNumerator();
    
    /*The denominator*/
    int int2 = this.getDenominator();
    
    /*Finds the greatest common divisor of the numerator and denominator*/
    while (int2 != 0) {
      
      /*The value Euclid's Method is performed on*/
      int tempValue = int2;
      
      /*Applies Euclid's Method*/
      int2 = int1 % int2;
      int1 = tempValue;
    }
    return int1;
  }
  
  /**
   * Returns a String object representing this object's value.
   * 
   * @return  The value associated with this object
   */
  @Override
  public String toString() {
    
    /* Stores the rational number*/
    StringBuilder rationalN = new StringBuilder();
    
    /* Append the numerator over denominator when the denominator can be reduced
     * to 1 or -1
     */
    if (Math.abs(((double)this.getDenominator()) / (double)this.findGCD()) == 1)
      rationalN.append(this.getNumerator() / this.getDenominator());
    /* Append the number in rational form*/
    else {
      
      /* The numerator that will be appended*/
      int appendNumerator = ((this.getDenominator() / 
                             Math.abs(this.getDenominator())) *
                            this.getNumerator()) / Math.abs(this.findGCD());
      
      /* The denominator that will be appended*/
      int appendDenominator = Math.abs(this.getDenominator()) /
                              Math.abs(this.findGCD());
      
      /* Formats the rational number as a StringBuilder*/
      rationalN.append(appendNumerator);
      rationalN.append("/");
      rationalN.append(appendDenominator);
    }
    /* Returns the RationalN as a String*/
    return rationalN.toString();
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
    
    /* Checks if the parameter is a RationalN*/
    if(obj instanceof RationalN) {
      
      /* The RationalN this RationalN is being compared to*/
      RationalN comparedRational = (RationalN)obj;
      
      /* The double equivalent of this rational number*/
      double valueThisRational = (double)(this.getNumerator()) / 
                                 (double)(this.getDenominator());
      
      /* The double equivalent of the compared rational number*/
      double valueComparedRational = (double)(comparedRational.getNumerator()) /
                                     (double)(comparedRational.getDenominator());
      
      /* Returns true if the values are the same, false otherwise.*/
      return (valueThisRational == valueComparedRational);
    }
    /* Returns false when the Object is not a RationalN*/
    else
      return false;
  }
  
}
