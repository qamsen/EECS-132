import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the RealN class
 */
public class RealNTester {
  
  /**
   * Tests the getter methods for RealN
   */
  @Test
  public void testRealNGetters() {
    
    /* The test RealN*/
    RealN number = new RealN(5.5);
    
    /* Checks if the values from the constructor equal the values from the
     * getter methods.
     */
    assertTrue(5.5 == number.getRealPart());
    assertTrue(0.0 == number.getImaginaryPart());
  }
  /**
   * Tests the toString method of RealN
   */
  @Test
  public void testRealNToString() {
    
    /* Test RealN with a positive value*/
    RealN numberP = new RealN(5.5);
    
    /* Checks if the output String is equal to the expected value*/
    assertEquals("5.5", numberP.toString());
  }
  
  /**
   * Tests the equals method of RealN
   */
  @Test
  public void testRealNEquals() {
    
    /* Test RealN*/
    RealN number = new RealN(5.5);
    
    /* A RealN with a parameter equal to the test*/
    RealN numberE = new RealN(5.5);
    
    /* A RealN with a parameter unequal to the test*/
    RealN numberUn = new RealN(-5.5);
    
    /* A non-RealN object*/
    Object testObject = new Object();
    
    /* Parameter is RealN with equal value*/
    assertTrue(number.equals(numberE));
    
    /* Parameter is RealN with unequal value*/
    assertFalse(number.equals(numberUn));
    
    /* Parameter is not a RealN*/
    assertFalse(number.equals(testObject));
  }
  
}
    