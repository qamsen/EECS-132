import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the ComplexN class
 */
public class ComplexNTester {
  
  /**
   * Test getter methods for ComplexN
   */
  @Test
  public void testComplexNGetters() {
    
    /* The test ComplexN*/
    ComplexN number = new ComplexN(4.5, 5.5);
    
    /* Checks if the values from the constructor are equal to the getter 
     * methods
     */
    assertTrue(4.5 == number.getRealPart());
    assertTrue(5.5 == number.getImaginaryPart());
  }
  
  /**
   * Test the toString method for ComplexN
   */
  @Test
  public void testComplexNToString() {
    
    /* A test ComplexN*/
    ComplexN number = new ComplexN(4.5, 5.5);
    
    /* A test ComplexN with a negative imaginary and real parts*/
    ComplexN negativeN = new ComplexN(-4.5, -5.5);
    
    /* A test ComplexN equal to zero*/
    ComplexN zeroN = new ComplexN(0.0, 0.0);
    
    /* First expected String*/
    String expected1 = "4.5 + 5.5i";
    
    /* Second expected String*/
    String expected2 = "-4.5 - 5.5i";
    
    /* Third expected String*/
    String expected3 = "0.0 + 0.0i";
    
    /* Checks if the output Strings are equal to the expected Strings*/
    assertEquals(expected1, number.toString());
    assertEquals(expected2, negativeN.toString());
    assertEquals(expected3, zeroN.toString());
  }
  
  /**
   * Test the equals method for ComplexN
   */
  @Test
  public void testComplexNEquals() {
    
    /* A test ComplexN*/
    ComplexN number = new ComplexN(4.5, 5.5);
    
    /* A test ComplexN equal to the first*/
    ComplexN numberE = new ComplexN(4.5, 5.5);
    
    /* A test ComplexN with an unequal real part*/
    ComplexN numberR = new ComplexN(4.0, 5.5);
    
    /* A test ComplexN with an unequal imaginary part*/
    ComplexN numberI = new ComplexN(4.5, 5.0);
    
    /* A non-ComplexN object*/
    Object testObject = new Object();
    
    /* Parameter is ComplexN with equal values*/
    assertTrue(number.equals(numberE));
    
    /* Parameter is ComplexN, unequal values*/
    assertFalse(number.equals(numberR));
    assertFalse(number.equals(numberI));
    
    /* Parameter is not a ComplexN*/
    assertFalse(number.equals(testObject));
    
  }
  
}