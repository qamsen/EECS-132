/**
 * Performs arithmetic functions on various number wrapper classes.
 * 
 *@author Kameron Damaska
 */
public class Arithmetic {
  
  /**
   * Adds the values wrapped in two NaturalN objects.
   * 
   * @param addend1  The first NaturalN.
   * @param addend2  The NaturalN being added.
   * @return         The sum of the two natural numbers wrapped in a NaturalN 
   *                 object.
   */
  public static NaturalN add(NaturalN addend1, NaturalN addend2) {
    /* Returns the sum of the two natural numbers in a NaturalN*/
    return new NaturalN((int)addend1.getRealPart() + (int)addend2.getRealPart());
  }

  /**
   * Adds the values wrapped in two IntegerN objects.
   * 
   * @param addend1  The first IntegerN.
   * @param addend2  The IntegerN being added.
   * @return         The sum of the two integers wrapped in a IntegerN object.
   */
  public static IntegerN add(IntegerN addend1, IntegerN addend2) {
    /* Returns the sum of the two integer numbers in an IntegerN*/
    return new IntegerN((int)addend1.getRealPart() + (int)addend2.getRealPart());
  }
  
  /**
   * Adds the values wrapped in two RationalN objects.
   * 
   * @param addend1  The first RationalN.
   * @param addend2  The RationalN being added.
   * @return         The sum of the two rational numbers wrapped in a
   *                 RationalN object.
   */
  public static RationalN add(RationalN addend1, RationalN addend2) {
    
    /* Stores the sum of the numerators*/
    int addedNumerator = addend1.getNumerator() * addend2.getDenominator() +
                         addend2.getNumerator() * addend1.getDenominator();
    
    /* Stores the returned denominator*/
    int addedDenominator = addend1.getDenominator() * addend2.getDenominator();
    
    /* Returns the sum of the two rational numbers in a RationalN*/
    return new RationalN(addedNumerator, addedDenominator);
  }
  
  /**
   * Adds the values wrapped in two RealN objects.
   * 
   * @param addend1  The first RealN.
   * @param addend2  The RealN being added.
   * @return         The sum of the two real numbers wrapped in a RealN object.
   */
  public static RealN add(RealN addend1, RealN addend2) {
    /* Returns the sum of the two real numbers in a RealN*/
    return new RealN(addend1.getRealPart() + addend2.getRealPart());
  }
  
  /**
   * Adds the values wrapped in two ComplexN objects.
   * 
   * @param addend1  The first ComplexN.
   * @param addend2  The ComplexN being added.
   * @return         The sum of the two complex numbers wrapped in a
   *                 ComplexN object.
   */
  public static ComplexN add(ComplexN addend1, ComplexN addend2) {
    
    /* Stores the sum of the real parts*/
    double addedRealPart = addend1.getRealPart() + addend2.getRealPart();
    
    /* Stores the sum of the imaginary parts*/
    double addedImaginaryPart = addend1.getImaginaryPart() + 
                                addend2.getImaginaryPart();
    
    /* Returns the sum of the two complex numbers in a ComplexN*/
    return new ComplexN(addedRealPart, addedImaginaryPart);
  }
  
  /**
   * Subtracts the values wrapped in two NaturalN objects.
   * 
   * @param minuend     The first NaturalN.
   * @param subtrahend  The NaturalN being subtracted.
   * @return            The difference between the two natural numbers 
   *                    wrapped in a NaturalN object.
   */
  public static NaturalN subtract(NaturalN minuend, NaturalN subtrahend) {
    /* Returns the difference between the natural numbers in a NaturalN*/
    return new NaturalN((int)minuend.getRealPart() - (int)subtrahend.getRealPart());
  }
  
  /**
   * Subtracts the values wrapped in two IntegerN objects.
   * 
   * @param minuend     The first IntegerN.
   * @param subtrahend  The IntegerN being subtracted.
   * @return            The difference between the two integers wrapped in a
   *                    IntegerN object.
   */
  public static IntegerN subtract(IntegerN minuend, IntegerN subtrahend) {
    /* Returns the difference between the integers in an IntegerN*/
    return new IntegerN((int)minuend.getRealPart() - (int)subtrahend.getRealPart());
  }
  
  /**
   * Subtracts the values wrapped in two RationalN objects.
   * 
   * @param minuend     The first RationalN.
   * @param subtrahend  The RationalN being subtracted.
   * @return            The difference between the two rational numbers wrapped
   *                    in a RationalN object.
   */
  public static RationalN subtract(RationalN minuend, RationalN subtrahend) {
    
    /* Stores the difference between numerators*/
    int subtractedNumerator = minuend.getNumerator() * subtrahend.getDenominator() -
                              subtrahend.getNumerator() * minuend.getDenominator();
    
    /* Stores the returned denominator*/
    int subtractedDenominator = minuend.getDenominator() * subtrahend.getDenominator();
    
    /* Returns the difference between the two rational numbers in a RationalN*/
    return new RationalN(subtractedNumerator, subtractedDenominator);
  }
  
  /**
   * Subtracts the values wrapped in two RealN objects.
   * 
   * @param minuend  The first RealN.
   * @param subtrahend  The RealN being subtracted.
   * @return      The difference between the two real numbers wrapped in a
   *              RealN object.
   */
  public static RealN subtract(RealN minuend, RealN subtrahend) {
    /* Returns the difference between the real numbers in a RealN*/
    return new RealN(minuend.getRealPart() - subtrahend.getRealPart());
  }
  
  /**
   * Subtracts the values wrapped in two ComplexN objects.
   * 
   * @param minuend     The first ComplexN.
   * @param subtrahend  The ComplexN being subtracted.
   * @return            The difference between the two complex numbers 
   *                    wrapped in a ComplexN object.
   */
  public static ComplexN subtract(ComplexN minuend, ComplexN subtrahend) {
    
    /* The difference between real parts*/
    double subtractedRealPart = minuend.getRealPart() - subtrahend.getRealPart();
    
    /* The difference between imaginary parts*/
    double subtractedImaginaryPart = minuend.getImaginaryPart() - 
                                     subtrahend.getImaginaryPart();
    
    /* Returns the difference between the two complex numbers in a ComplexN*/
    return new ComplexN(subtractedRealPart, subtractedImaginaryPart);
  }
  
  /**
   * Multiplies the values wrapped in two NaturalN objects
   * 
   * @param factor1  The first NaturalN.
   * @param factor2  The NaturalN being multiplied.
   * @return         The product of the two natural numbers wrapped in a
   *                 NaturalN object.
   */
  public static NaturalN multiply(NaturalN factor1, NaturalN factor2) {
    /* Returns the product of the two natural numbers in a NaturalN*/
    return new NaturalN((int)factor1.getRealPart() * (int)factor2.getRealPart());
  }
  
  /**
   * Multiplies the values wrapped in two IntegerN objects
   * 
   * @param factor1  The first IntegerN.
   * @param factor2  The IntegerN being multiplied.
   * @return         The product of the two integers wrapped in a IntegerN 
   *                 object.
   */
  public static IntegerN multiply(IntegerN factor1, IntegerN factor2) {
    /* Returns the product of the two integers in an IntegerN*/
    return new IntegerN((int)factor1.getRealPart() * (int)factor2.getRealPart());
  }
  
  /**
   * Multiplies the values wrapped in two RationalN objects
   * 
   * @param factor1  The first RationalN.
   * @param factor2  The RationalN being multiplied
   * @return         The product of the two rational numbers wrapped in a
   *                 RationalN object.
   */
  public static RationalN multiply(RationalN factor1, RationalN factor2) {
    
    /* The product of the numerators*/
    int multipliedNumerator = factor1.getNumerator() * factor2.getNumerator();
    
    /* The returned denominator*/
    int multipliedDenominator = factor1.getDenominator() * 
                                factor2.getDenominator();
    
    /* Returns the product of the two rational numbers in a RationalN*/
    return new RationalN(multipliedNumerator, multipliedDenominator);
  }
  
  /**
   * Multiplies the values wrapped in two RealN objects
   * 
   * @param factor1  The first RealN.
   * @param factor2  The RealN being multiplied
   * @return         The product of the two real numbers wrapped in a RealN 
   *                 object.
   */
  public static RealN multiply(RealN factor1, RealN factor2) {
    /* Returns the product of the two real numbers in an RealN*/
    return new RealN(factor1.getRealPart() * factor2.getRealPart());
  }
  
  /**
   * Multiplies the values wrapped in two ComplexN objects
   * 
   * @param factor1  The first ComplexN.
   * @param factor2  The ComplexN being multiplied
   * @return         The product of the two complex numbers wrapped in a
   *                 ComplexN object.
   */
  public static ComplexN multiply(ComplexN factor1, ComplexN factor2) {
    
    /* Stores the real part of the multiplication*/
    double productReal = factor1.getRealPart() * factor2.getRealPart() -
                         factor1.getImaginaryPart() * factor2.getImaginaryPart();
    
    /* Stores the imaginary part of the multiplication*/
    double productImaginary = factor1.getRealPart() * factor2.getImaginaryPart() +
                              factor2.getRealPart() * factor1.getImaginaryPart();
    
    /* Returns the product of the two complex numbers in a ComplexN*/
    return new ComplexN(productReal, productImaginary);
  }
  
  /**
   * Divides the values wrapped in two NaturalN objects
   * 
   * @param dividend              The dividend NaturalN.
   * @param divisor               The divisor NaturalN
   * @return                      The quotient of the two natural numbers  
   *                              wrapped in a NaturalN object.
   * @throws ArithmeticException  If the divisor is 0.
   */
  public static NaturalN divide(NaturalN dividend, NaturalN divisor) 
    throws ArithmeticException {
    
    /* Throws an AirthmeticException when the divisor is 0*/
    if (divisor.getRealPart() == 0)
      throw new ArithmeticException("Can't divide by 0!");
    
    /*Returns the quotient of the two natural numbers in a NaturalN object*/
    return new NaturalN((int)dividend.getRealPart() / (int)divisor.getRealPart());
  }
  
  /**
   * Divides the values wrapped in two IntegrN objects
   * 
   * @param dividend              The dividend IntegerN.
   * @param divisor               The divisor IntegerN.
   * @return                      The quotient of the integers wrapped in a  
   *                              IntegerN object.
   * @throws ArithmeticException  If divisor is 0.
   */
  public static IntegerN divide(IntegerN dividend, IntegerN divisor) 
    throws ArithmeticException {
    
    /* Throws an ArithmeticException when the divisor is 0*/
    if (divisor.getRealPart() == 0)
      throw new ArithmeticException("Can't Divide by 0!");
    
    /* Returns the quotient of the integers in an IntegerN*/
    return new IntegerN((int)dividend.getRealPart() / (int)divisor.getRealPart());
  }
  
  /**
   * Divides the values wrapped in two RationalN objects
   * 
   * @param dividend              The dividend RationalN.
   * @param divisor               The divisor RationalN.
   * @return                      The quotient of the two rational numbers 
   *                              wrapped in a RationalN object.
   * @throws ArithmeticException  If the divisor is 0.
   */
  public static RationalN divide(RationalN dividend, RationalN divisor)
    throws ArithmeticException {
    
    /*Throws an ArithmeticException when the divisor is 0*/
    if (divisor.getRealPart() == 0)
      throw new ArithmeticException("Can't Divide by 0!");
    
    /* The quotient's numerator*/
    int quotientNumerator = dividend.getNumerator() * divisor.getDenominator();
    
    /* The quotient's denominator*/
    int quotientDenominator =    dividend.getDenominator() * 
                                divisor.getNumerator();
    
    /* Returns the quotient of the two rational numbers in a RationalN*/
    return new RationalN(quotientNumerator, quotientDenominator);
  }
  
  /**
   * Divides the values wrapped in two RealN objects
   * 
   * @param dividend              The dividend RealN.
   * @param divisor               The divisor RealN.
   * @return                      The quotient of the two real numbers wrapped
   *                              in a RealN object.
   * @throws ArithmeticException  If the divisor is 0.
   */
  public static RealN divide(RealN dividend, RealN divisor) 
    throws ArithmeticException {
    
    /*Throws an ArithmeticException when the divisor is 0*/
    if (divisor.getRealPart() == 0)
      throw new ArithmeticException("Can't divide by 0!");
    
    /* Returns the quotient of the two real numbers in a RealN*/
    return new RealN(dividend.getRealPart() / divisor.getRealPart());
  }
  
  /**
   * Divides the values wrapped in two ComplexN objects
   * 
   * @param dividend              The dividend ComplexN.
   * @param divisor               The divisor ComplexN.
   * @return                      The quotient of the two complex numbers 
   *                              wrapped in a ComplexN object.
   * @throws ArithmeticException  If the divisor is 0.
   */
  public static ComplexN divide(ComplexN dividend, ComplexN divisor) 
    throws ArithmeticException {
    
    /* Throws an ArithmeticException when the divisor is 0*/
    if (divisor.getRealPart() == 0 && divisor.getImaginaryPart() == 0)
      throw new ArithmeticException("Can't divide by 0!");
    
    /* The real part of the dividend*/
    double realDividend = dividend.getRealPart();
    
    /* The imaginary part of the dividend*/
    double imaginaryDividend = dividend.getImaginaryPart();
    
    /* The real part of the divisor*/
    double realDivisor = divisor.getRealPart();
    
    /* The imaginary part of the divisor*/
    double imaginaryDivisor = divisor.getImaginaryPart();
    
    /* The real part of the quotient*/
    double realQuotient = (realDividend * realDivisor +
                           imaginaryDividend * imaginaryDivisor) / 
                          (realDivisor * realDivisor +
                           imaginaryDivisor * imaginaryDivisor);
    
    /* The imaginary part of the quotient*/
    double imaginaryQuotient = (realDivisor * imaginaryDividend - 
                                realDividend * imaginaryDivisor) /
                               (realDivisor * realDivisor +
                                imaginaryDivisor * imaginaryDivisor);
    
    /* Returns the quotient of the two complex numbers in a ComplexN*/
    return new ComplexN(realQuotient, imaginaryQuotient);
  }
  
}