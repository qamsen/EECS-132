import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the IntegerN class
 */
public class IntegerNTester {
  
  /**
   * Test the IntegerN getter methods
   */
  @Test
  public void testIntegeNGetters() {
    
    /* Test IntegerN*/
    IntegerN number = new IntegerN(5);
    
    /* Test real and imaginary getters, imaginary part should be 0*/
    assertTrue(5.0 == number.getRealPart());
    assertTrue(0.0 == number.getImaginaryPart());
    
    /* Test numerator and denominator getters, denominator should be 1*/
    assertTrue(5 == number.getNumerator());
    assertTrue(1 == number.getDenominator());
  }
  
  /**
   * Test the IntegerN toString method
   */
  @Test
  public void testIntegerNToString() {
    
    /* Test positive IntegerN*/
    IntegerN numberP = new IntegerN(5);
    
    /* Test negative IntegerN*/
    IntegerN numberN = new IntegerN(-5);
    
    /* Test toSting for positive and negative numbers*/
    assertEquals("5", numberP.toString());
    assertEquals("-5", numberN.toString());
  }
  
  /**
   * Test the IntegerN equals method
   */
  @Test
  public void testIntegerNEquals() {
    
    /* Test IntegerN*/
    IntegerN numberTest = new IntegerN(5);
    
    /* IntegerN with equal parameter to test*/
    IntegerN numberE = new IntegerN(5);
    
    /* IntegerN with unequal parameter to test*/
    IntegerN numberUn = new IntegerN(-3);
    
    /* Non-IntegerN object*/
    Object testObject = new Object();
    
    /* Return true when both IntegerN have equal parameters*/
    assertTrue(numberTest.equals(numberE));
    
    /* Return false when the IntegerNs have unequal parameters*/
    assertFalse(numberTest.equals(numberUn));
    
    /* Return false when parameter is not an IntegerN*/
    assertFalse(numberTest.equals(testObject));
  }
  
}
