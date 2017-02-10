import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 * Test the NaturalN class
 */
public class NaturalNTester {
  
  /**
   * Stores exception test
   */
  @Rule
  public final ExpectedException exception = ExpectedException.none();
  
  /**
   * Tests the excpetion thrown when NaturalN is negative
   */
  @Test
  public void throwsWhenNaturalNLessThanZero() {
    
    /* Properties of the exception*/
    exception.expect(ArithmeticException.class);
    exception.expectMessage("-2" + " "+  "is not a natural number!");
    
    /* NaturalN that throws the exception*/
    NaturalN throwsException = new NaturalN(-2);
  }
  
  /**
   * Test the NaturalN getter methods
   */
  @Test
  public void testNaturalNGetters() {
    
    /* Test NaturalN*/
    NaturalN number = new NaturalN(5);
    
    /* Test the real and imaginary getters, imaginary part should be 0*/
    assertTrue(5.0 == number.getRealPart());
    assertTrue(0.0 == number.getImaginaryPart());
    
    /* Test numerator and denominator getters, denominator should be 1*/
    assertTrue(5 == number.getNumerator());
    assertTrue(1 == number.getDenominator());
  }
  
  /**
   * Test the NaturalN toString method
   */
  @Test
  public void testNaturalNToString(){
    
    /* Test NaturalN, also tests 0*/
    NaturalN numberNatural = new NaturalN(0);
    
    /* Test toString for a natural number*/
    assertEquals("0", numberNatural.toString());
  }
  
  /**
   * Test the IntegerN
   */
  @Test
  public void testNaturalNEquals() {
    
    /* Test NaturalN*/
    NaturalN numberTest = new NaturalN(2);
    
    /* NaturalN with equal parameter to test*/
    NaturalN numberE = new NaturalN(2);
    
    /* NaturalN with unequal parameter to test*/
    NaturalN numberUn = new NaturalN(0);
    
    /* Non-NaturalN object*/
    Object testObject = new Object();
    
    /* Return true when both IntegerN have equals parameters*/
    assertTrue(numberTest.equals(numberE));
    
    /* Return false when the IntegerNs have unequal parameters*/
    assertFalse(numberTest.equals(numberUn));
    
    /* Return false when parameter is not an IntegerN*/
    assertFalse(numberTest.equals(testObject));
  }
  
}