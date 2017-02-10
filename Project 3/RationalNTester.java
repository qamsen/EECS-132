import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 * Test the RationalN class
 */
public class RationalNTester {
  
  /**
   * Stores exception test
   */
  @Rule
  public final ExpectedException exception = ExpectedException.none();
  
  /**
   * Tests exception thrown by the constructor when denominator is 0.
   */
  @Test
  public void throwsWhenDivideByZero() {
    
    /* Properties of the exception*/
    exception.expect(ArithmeticException.class);
    exception.expectMessage("Can't divide by 0!");
    
    /* RationalN that will throw exception*/
    RationalN divideBy0 = new RationalN(5, 0);
  }

  /**
   * Tests the getter methods of RationalN
   */
  @Test
  public void testRationalNGetters() {
    
    RationalN number = new RationalN(4, 5);
    
    /* Test real and imaginary getters, imaginary part should be 0*/
    assertTrue(4.0 / 5.0 == number.getRealPart());
    assertTrue(0 == number.getImaginaryPart());
    
    /* Test numerator and denominator getters*/
    assertTrue(4 == number.getNumerator());
    assertTrue(5 == number.getDenominator());
  }
  
  /**
   * Tests the toString method of RationalN
   */
  @Test
  public void testRationalNToString() {
    
    /* Positive and Negative RationalNs with a denominator of 1*/
    RationalN number1 = new RationalN(5, 1);
    RationalN numberN1 = new RationalN(5, -1);
    
    /* RationalNs with various combinations of positive and negative
     * numerators and denominators
     */
    RationalN posNposD = new RationalN(5, 4);
    RationalN posNnegD = new RationalN(5, -4);
    RationalN negNposD = new RationalN(-5, 4);
    RationalN negNnegD = new RationalN(-5, -4);
    
    /* RationalNs that can be simplified*/
    RationalN simplified1 = new RationalN(10, 4);
    RationalN simplified2 = new RationalN(10, 2);
    
    /* Test toString with a denominator of 1*/
    assertEquals("5", number1.toString());
    assertEquals("-5", numberN1.toString());
    
    /* Test toString with various combination of positive and negative
     * numerators and denominators
     */
    assertEquals("5/4", posNposD.toString());
    assertEquals("5/4", negNnegD.toString());
    assertEquals("-5/4", posNnegD.toString());
    assertEquals("-5/4", negNposD.toString());
    
    /* Test toString with fractions that can be reduced by greatest common
     * divisor
     */
    assertEquals("5/2", simplified1.toString());
    assertEquals("5", simplified2.toString());
  }
  
  /**
   * Tests the equals method of RationalN
   */
  @Test
  public void testRationalNEquals() {
    
    /* Test RationalN*/
    RationalN number = new RationalN(5, 4);
    
    /* RationalN with equal parameters to the test RationalN*/
    RationalN numberE = new RationalN(5, 4);
    
    /* RationalN with equal ratio between numerator and denominator*/
    RationalN numberR = new RationalN(10, 8);
    
    /* RationalN with unequal numerator*/
    RationalN numberNu = new RationalN(4, 4);
    
    /* RationalN wit unequal denominator*/
    RationalN numberDe = new RationalN(5, 3);
    
    /* Non-RationalN object*/
    Object testObject = new Object();
    
    /* Tests with equals numerator / denominator return true*/
    assertTrue(number.equals(numberE));
    assertTrue(number.equals(numberR));
    
    /* Tests with unequal numerator / denominator return false*/
    assertFalse(number.equals(numberNu));
    assertFalse(number.equals(numberDe));
    
    /* Tests non-RationalN parameter*/
    assertFalse(number.equals(testObject));
  }
  
}
    