import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;


/**
 * Tests the Arithmetic class
 */
public class ArithmeticTester {
  
  /* Stores the exception test*/
  @Rule
  public final ExpectedException exception = ExpectedException.none();
  
  /**
   * Tests the add method
   */
  @Test
  public void testAdd() {
    
    /* Two test NaturalN*/
    NaturalN nSmall = new NaturalN(1);
    NaturalN nLarge = new NaturalN(2);
    
    /* Two test IntegerN*/
    IntegerN iSmall = new IntegerN(1);
    IntegerN iLarge = new IntegerN(2);
    
    /* Two test RationalN*/
    RationalN rSmall = new RationalN(1, 2);
    RationalN rLarge = new RationalN(3, 2);
    
    /* Two test RealN*/
    RealN realSmall = new RealN(1.0);
    RealN realLarge = new RealN(2.0);
    
    /* Two test ComplexN*/
    ComplexN cSmall = new ComplexN(1.0, 2.0);
    ComplexN cLarge = new ComplexN(2.0, 1.0);
    
    /* Test addition of two NaturalN*/
    assertEquals("3", (Arithmetic.add(nSmall, nLarge)).toString());
    assertEquals("class NaturalN", ((Arithmetic.add(nSmall, nLarge)).getClass()).toString());
  
  
    /* Test addition of two IntegerN*/
    assertEquals("3", (Arithmetic.add(iSmall, iLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.add(iSmall, iLarge)).getClass()).toString());
  
    /* Test addition of an IntegerN and a narrower type*/
    assertEquals("3", (Arithmetic.add(iSmall, nLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.add(iSmall, nLarge)).getClass()).toString());
    
    /* Test addition of two RationalN*/
    assertEquals("2", (Arithmetic.add(rSmall, rLarge)).toString());
    assertEquals("class RationalN",
                ((Arithmetic.add(rSmall, rLarge)).getClass()).toString());
    
    /* Test addition of a RationalN and a narrower type*/
    assertEquals("5/2", (Arithmetic.add(rSmall, nLarge)).toString());
    assertEquals("class RationalN", 
                ((Arithmetic.add(rSmall, nLarge)).getClass()).toString());
    
    /* Test addition of two RealN*/
    assertEquals("3.0", (Arithmetic.add(realSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.add(realSmall, realLarge)).getClass()).toString());
    
    /* Test addition of a RealN and a narrower types*/
    assertEquals("2.5", (Arithmetic.add(rSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.add(rSmall, realLarge)).getClass()).toString());
    
    /* Test addition of two ComplexN*/
    assertEquals("3.0 + 3.0i", (Arithmetic.add(cSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.add(cSmall, cLarge)).getClass()).toString());
    
    /* Test addition of a ComplexN and a narrower type*/
    assertEquals("3.0 + 1.0i", (Arithmetic.add(realSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.add(realSmall, cLarge)).getClass()).toString());
  }
  
  /**
   * Tests the excpetion thrown when a larger NaturalN is subtracted from a
   * smaller NaturalN
   */
  @Test
  public void throwsWhenSubtractLargeNaturalFromSmall() {
    
    /* Two test NaturalN*/
    NaturalN nSmall = new NaturalN(1);
    NaturalN nLarge = new NaturalN(2);
    
    /* Properties of the exception*/
    exception.expect(ArithmeticException.class);
    exception.expectMessage("-1" + " "+  "is not a natural number!");
    
    /* NaturalN that throws the exception*/
    Arithmetic.subtract(nSmall, nLarge);
  }
  
  /**
   * Tests the subtract method
   */
  @Test
  public void testSubtract() {
    
    /* Two test NaturalN*/
    NaturalN nSmall = new NaturalN(1);
    NaturalN nLarge = new NaturalN(2);
    
    /* Two test IntegerN*/
    IntegerN iSmall = new IntegerN(1);
    IntegerN iLarge = new IntegerN(2);
    
    /* Two test RationalN*/
    RationalN rSmall = new RationalN(1, 2);
    RationalN rLarge = new RationalN(3, 2);
    
    /* Two test RealN*/
    RealN realSmall = new RealN(1.0);
    RealN realLarge = new RealN(2.0);
    
    /* Two test ComplexN*/
    ComplexN cSmall = new ComplexN(1.0, 2.0);
    ComplexN cLarge = new ComplexN(2.0, 1.0);
    
    /* Test subtraction of two NaturalN*/
    assertEquals("1", (Arithmetic.subtract(nLarge, nSmall)).toString());
    assertEquals("class NaturalN", 
                ((Arithmetic.subtract(nLarge, nSmall)).getClass()).toString());
  
  
    /* Test subtraction of two IntegerN*/
    assertEquals("-1", (Arithmetic.subtract(iSmall, iLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.subtract(iSmall, iLarge)).getClass()).toString());
  
    /* Test subtraction of an IntegerN and a narrower type*/
    assertEquals("-1", (Arithmetic.subtract(iSmall, nLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.subtract(iSmall, nLarge)).getClass()).toString());
    
    /* Test addition of two RationalN*/
    assertEquals("-1", (Arithmetic.subtract(rSmall, rLarge)).toString());
    assertEquals("class RationalN",
                ((Arithmetic.subtract(rSmall, rLarge)).getClass()).toString());
    
    /* Test subtraction of a RationalN and a narrower type*/
    assertEquals("-3/2", (Arithmetic.subtract(rSmall, nLarge)).toString());
    assertEquals("class RationalN", 
                ((Arithmetic.subtract(rSmall, nLarge)).getClass()).toString());
    
    /* Test subtraction of two RealN*/
    assertEquals("-1.0", (Arithmetic.subtract(realSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.subtract(realSmall, realLarge)).getClass()).toString());
    
    /* Test subtraction of a RealN and a narrower types*/
    assertEquals("-1.5", (Arithmetic.subtract(rSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.subtract(rSmall, realLarge)).getClass()).toString());
    
    /* Test subtraction of two ComplexN*/
    assertEquals("-1.0 + 1.0i", (Arithmetic.subtract(cSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.subtract(cSmall, cLarge)).getClass()).toString());
    
    /* Test subraction of a ComplexN and a narrower type*/
    assertEquals("-1.0 - 1.0i", (Arithmetic.subtract(realSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.subtract(realSmall, cLarge)).getClass()).toString());
  }
  
  /**
   * Tests the excpetion thrown when the divisor is 0.
   */
  @Test
  public void throwsWhenDivisorIsZero() {
    
    /* Two test ComplexN*/
    ComplexN dividend = new ComplexN(1.0, 2.0);
    ComplexN divisor = new ComplexN(0.0, 0.0);
    
    /* Properties of the exception*/
    exception.expect(ArithmeticException.class);
    exception.expectMessage("Can't divide by 0!");
    
    /* NaturalN that throws the exception*/
    Arithmetic.divide(dividend, divisor);
  }
  
  /**
   * Tests the multiply method
   */
  @Test
  public void testDivide() {
    
    /* Two test NaturalN*/
    NaturalN nSmall = new NaturalN(1);
    NaturalN nLarge = new NaturalN(2);
    
    /* Two test IntegerN*/
    IntegerN iSmall = new IntegerN(1);
    IntegerN iLarge = new IntegerN(2);
    
    /* Two test RationalN*/
    RationalN rSmall = new RationalN(1, 2);
    RationalN rLarge = new RationalN(3, 2);
    
    /* Two test RealN*/
    RealN realSmall = new RealN(1.0);
    RealN realLarge = new RealN(2.0);
    
    /* Two test ComplexN*/
    ComplexN cSmall = new ComplexN(1.0, 2.0);
    ComplexN cLarge = new ComplexN(2.0, 1.0);
    
    /* Test divison of two NaturalN, performs integer divison*/
    assertEquals("2", (Arithmetic.divide(nLarge, nSmall)).toString());
    assertEquals("class NaturalN", 
                ((Arithmetic.divide(nLarge, nSmall)).getClass()).toString());
  
  
    /* Test division of two IntegerN, performs integer divison*/
    assertEquals("0", (Arithmetic.divide(iSmall, iLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.divide(iSmall, iLarge)).getClass()).toString());
  
    /* Test division of an IntegerN and a narrower type, performs integer
     * division
     */
    assertEquals("0", (Arithmetic.divide(iSmall, nLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.divide(iSmall, nLarge)).getClass()).toString());
    
    /* Test division of two RationalN*/
    assertEquals("1/3", (Arithmetic.divide(rSmall, rLarge)).toString());
    assertEquals("class RationalN",
                ((Arithmetic.divide(rSmall, rLarge)).getClass()).toString());
    
    /* Test division of a RationalN and a narrower type*/
    assertEquals("1/4", (Arithmetic.divide(rSmall, nLarge)).toString());
    assertEquals("class RationalN", 
                ((Arithmetic.divide(rSmall, nLarge)).getClass()).toString());
    
    /* Test division of two RealN*/
    assertEquals("0.5", (Arithmetic.divide(realSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.divide(realSmall, realLarge)).getClass()).toString());
    
    /* Test division of a RealN and a narrower types*/
    assertEquals("0.25", (Arithmetic.divide(rSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.divide(rSmall, realLarge)).getClass()).toString());
    
    /* Test division of two ComplexN*/
    assertEquals("0.8 + 0.6i", (Arithmetic.divide(cSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.divide(cSmall, cLarge)).getClass()).toString());
    
    /* Test division of a ComplexN and a narrower types*/
    assertEquals("0.4 - 0.2i", (Arithmetic.divide(realSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.divide(realSmall, cLarge)).getClass()).toString());
  }
  
  
  /**
   * Tests the multiply method
   */
  @Test
  public void testMultiply() {
    
    /* Two test NaturalN*/
    NaturalN nSmall = new NaturalN(1);
    NaturalN nLarge = new NaturalN(2);
    
    /* Two test IntegerN*/
    IntegerN iSmall = new IntegerN(1);
    IntegerN iLarge = new IntegerN(2);
    
    /* Two test RationalN*/
    RationalN rSmall = new RationalN(1, 2);
    RationalN rLarge = new RationalN(3, 2);
    
    /* Two test RealN*/
    RealN realSmall = new RealN(1.0);
    RealN realLarge = new RealN(2.0);
    
    /* Two test ComplexN*/
    ComplexN cSmall = new ComplexN(1.0, 2.0);
    ComplexN cLarge = new ComplexN(2.0, 1.0);
    
    /* Test divison of two NaturalN*/
    assertEquals("2", (Arithmetic.multiply(nLarge, nSmall)).toString());
    assertEquals("class NaturalN", 
                ((Arithmetic.multiply(nLarge, nSmall)).getClass()).toString());
  
  
    /* Test multiplication of two IntegerN*/
    assertEquals("2", (Arithmetic.multiply(iSmall, iLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.multiply(iSmall, iLarge)).getClass()).toString());
  
    /* Test multiplication of an IntegerN and a narrower type*/
    assertEquals("2", (Arithmetic.multiply(iSmall, nLarge)).toString());
    assertEquals("class IntegerN", 
                ((Arithmetic.multiply(iSmall, nLarge)).getClass()).toString());
    
    /* Test multiplication of two RationalN*/
    assertEquals("3/4", (Arithmetic.multiply(rSmall, rLarge)).toString());
    assertEquals("class RationalN",
                ((Arithmetic.multiply(rSmall, rLarge)).getClass()).toString());
    
    /* Test multiplication of a RationalN and a narrower type*/
    assertEquals("1", (Arithmetic.multiply(rSmall, nLarge)).toString());
    assertEquals("class RationalN", 
                ((Arithmetic.multiply(rSmall, nLarge)).getClass()).toString());
    
    /* Test multiplication of two RealN*/
    assertEquals("2.0", (Arithmetic.multiply(realSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.multiply(realSmall, realLarge)).getClass()).toString());
    
    /* Test multiplication of a RealN and a narrower types*/
    assertEquals("1.0", (Arithmetic.multiply(rSmall, realLarge)).toString());
    assertEquals("class RealN", 
                ((Arithmetic.multiply(rSmall, realLarge)).getClass()).toString());
    
    /* Test multiplication of two ComplexN*/
    assertEquals("0.0 + 5.0i", (Arithmetic.multiply(cSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.multiply(cSmall, cLarge)).getClass()).toString());
    
    /* Test multiplication of a ComplexN and a narrower types*/
    assertEquals("2.0 + 1.0i", (Arithmetic.multiply(realSmall, cLarge)).toString());
    assertEquals("class ComplexN", 
                ((Arithmetic.multiply(realSmall, cLarge)).getClass()).toString());
  }
  
}