import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.io.PrintStream; 
import java.io.ByteArrayOutputStream; 
import java.io.OutputStream;

/**
 * A class that tests the methods of the DNA class.
 * 
 * @author Kameron Damaska
 */
public class DNATester {
  
  /**
   * Tests the toString method
   */
  @Test
  public void toStringTester() {
    
    /* Initializes DNA of length 0, 1, and many*/
    DNA emptyDNA = new DNA();
    
    DNA oneLengthDNA = new DNA();
    oneLengthDNA.addToFront(DNA.Base.T);
    
    DNA manyLengthDNA = new DNA();
    manyLengthDNA.addToFront(DNA.Base.A);
    manyLengthDNA.addToFront(DNA.Base.C);
    manyLengthDNA.addToFront(DNA.Base.G);
    manyLengthDNA.addToFront(DNA.Base.T);
  
  /* Run tests to see if the String output matches the expected value*/
  assertEquals("Returns an empty String", emptyDNA.toString(), "");
  assertEquals("Returns a String of the Base", oneLengthDNA.toString(), "T");
  assertEquals("Returns DNA sequence as String", manyLengthDNA.toString(), 
                                                 "TGCA");
  }
  
  /**
   * Tests the string2DNA method
   */
  @Test
  public void string2DNATester() {
    
    /* Returns true if the error was caught*/
    boolean caughtError = false;
    
    /* Trying an empty String*/
    try {
      DNA.string2DNA("");
    }
    catch (IllegalArgumentException e) {
      caughtError = true;
    }
    
    assertTrue("Error was caught", caughtError);
    
    /* Resets caughtError*/
    caughtError = false;
    
    /* Trying a String that isn't a DNA sequence*/
    try {
      DNA.string2DNA("HELLO");
    }
    catch (IllegalArgumentException e) {
      caughtError = true;
    }
    
    assertTrue("Error was caught", caughtError);
    
    /* Constructing a DNA for testing*/
    DNA dna = new DNA();
    
    dna.addToBack(DNA.Base.T);
    
    /* testing a String that represent DNA*/
    assertEquals(DNA.string2DNA("T"), dna);
    
    /* Adding bases to the test DNA*/
    dna.addToBack(DNA.Base.C);
    dna.addToBack(DNA.Base.A);
    dna.addToBack(DNA.Base.A);
    dna.addToBack(DNA.Base.G);
    dna.addToBack(DNA.Base.T);
    
    /* testing a String that represent DNA*/
    assertEquals(DNA.string2DNA("TCAAGT"), dna);
  }
  
  /**
   * Testing the splice method
   */
  @Test
  public void spliceTester() {
    
    /* Testing DNAs*/
    DNA emptyDNA = new DNA();
    DNA dna1 = DNA.string2DNA("TGTG");
    DNA dna2 = DNA.string2DNA("AACC");
    
    /* Splicing the empty String onto a DNA*/
    dna1.splice(emptyDNA, 5);
    
    assertEquals("The DNA hasn't chanegd", dna1, DNA.string2DNA("TGTG"));
    
    /* Splicing none of the parameter*/
    dna1.splice(dna2, 0);
    
    assertEquals("The DNA is appended", dna1, DNA.string2DNA("TGTGAACC"));
    
    /* Reseting the DNA strand*/
    dna1 = DNA.string2DNA("TGTG");
    
    /* Splicing part of the parameter*/
    dna1.splice(dna2, 1);
    
    assertEquals("The DNA is appended", dna1, DNA.string2DNA("TGTGACC"));
   
    /* Reseting the DNA strand*/
    dna1 = DNA.string2DNA("TGTG");
    
     /* Splicing all but one base on the parameter*/
    dna1.splice(dna2, 3);
    
    assertEquals("The DNA is appended", dna1, DNA.string2DNA("TGTGC"));
    
    /* Reseting the DNA strand*/
    dna1 = DNA.string2DNA("TGTG");
    
    /* Destroying the DNA parameter with the splice*/
    dna1.splice(dna2, 4);
    
    assertEquals("The DNA hasn't chanegd", dna1, DNA.string2DNA("TGTG"));
    
    /* "Overkilling" the DNA parameter with the splice*/
    dna1.splice(dna2, 5);
    
    assertEquals("The DNA hasn't chanegd", dna1, DNA.string2DNA("TGTG"));
    
    /* Splicing DNA onto an empty DNA strand*/
    emptyDNA.splice(dna1, 1);
    
    assertEquals("The DNA is appended", emptyDNA, DNA.string2DNA("GTG"));
  }
  
  /**
   * Tests the overlaps method
   */
  @Test
  public void overlapsTester() {
    
    /* An empty DNA*/
    DNA emptyDNA = new DNA();
    
    /* DNA with one Base*/
    DNA oneBase = DNA.string2DNA("T");
    
    /* Another test DNA with one Base*/
    DNA oneBase1 = DNA.string2DNA("A");
    
    /* A test DNA that matches the next one up at 3*/
    DNA testDNA1 = DNA.string2DNA("ACCATTGT");
    
    /* A test DNA that matches the previous one up at 3*/
    DNA testDNA2 = DNA.string2DNA("GTAATACC");
    
    assertTrue("Empty DNA are equal at 0", DNA.overlaps(emptyDNA, emptyDNA, 0));
    
    assertFalse("Empty DNA not equal at 1", DNA.overlaps(emptyDNA, emptyDNA, 1));
    
    assertTrue("DNA are equal at 1", DNA.overlaps(oneBase, oneBase, 1));
    
    assertFalse("DNA are not equal at 1", DNA.overlaps(oneBase1, oneBase, 1));
    
    assertFalse("DNA are not equal at 2", DNA.overlaps(oneBase, oneBase, 2));
    
    assertFalse("DNA are not equal at 2", DNA.overlaps(testDNA2, testDNA1, 2));
    
    assertTrue("DNA are equal at 3", DNA.overlaps(testDNA2, testDNA1, 3));
    
    assertFalse("DNA are not equal at 2", DNA.overlaps(testDNA2, testDNA1, 4));
                
  }
  
  /**
   * Tests the main method
   */
  @Test
  public void mainTester() {
    
    /* Redirects the output of the main method*/
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);
    System.setOut(ps);
    
    /* Two DNA parameters with no overlap*/
    String[] noOverlap = {"A", "C"};
    DNA.main(noOverlap);
    
    assertEquals("\"AC\" matches the expected output", "AC\r\n", 
                                                           os.toString());
    
    /* Resets the Output stream*/
    os.reset();
    
    /* Two DNA parameters that fully overlap each other*/
    String[] fullOverlap = {"ACA", "ACA"};
    DNA.main(fullOverlap);
    
    assertEquals("\"ACA\" matches the expected output", "ACA\r\n", 
                                                        os.toString());
    
    /* Resets the output stream*/
    os.reset();
    
    /* Two DNA parameters with the overlap being the start of the first and the
     * end of the second*/
    String[] frontOverlap = {"ACAAGTG", "ATTACAA"};
    DNA.main(frontOverlap);
    
    assertEquals("\"ATTACAAGTG\" matches the expected output", "ATTACAAGTG\r\n",
                                                               os.toString());
    
    /* Resets the output stream*/
    os.reset();
    
    /* Two DNA parameters with the overlap being the start of the second and
     * the end of the first.*/
    String[] secondOverlap = {"GGGGTACA", "ACACC"};
    DNA.main(secondOverlap);
    
    assertEquals("\"GGGGTACACC\" matches the expected output", "GGGGTACACC\r\n",
                                                                os.toString());
    /* Resets the output stream*/
    os.reset();
    
    /* Parameters that will inform the user that bad data was input*/
    String[] oneDNA ={"GGAAG"};
    String[] threeDNA = {"AAAA", "CCCC", "TTTT"};
    String[] notDNA = {"Bananas"};
    
    /* Tests the oneDNA input*/
    DNA.main(oneDNA);
    assertEquals("\"Please enter two DNA sequences\" matches the expected output",
                 "Please enter two DNA sequences\r\n", os.toString());
    
    /* Resets the output stream*/
    os.reset();
    
    /* Tests the threeDNA input*/
    DNA.main(threeDNA);
    assertEquals("\"Please enter two DNA sequences\" matches the expected output",
                 "Please enter two DNA sequences\r\n", os.toString());
    
    /* Resets the output stream*/
    os.reset();
    
    /* Tests the notDNA input*/
    DNA.main(notDNA);
    assertEquals("\"Please enter two DNA sequences\" matches the expected output",
                "Please enter two DNA sequences\r\n", os.toString());
  }
  
  /**
   * Tests the compareTo
   */
  @Test
  public void compareTo() {
    
    /* An empty DNA*/
    DNA emptyDNA = new DNA();
    
    /* The shorter of two DNA*/
    DNA shortDNA = DNA.string2DNA("ACGT");
    
    /* The longer of two DNA*/
    DNA longDNA = DNA.string2DNA("ACCGT");
    
    /* A DNA that is alphabetically after the short DNA, identical in length*/
    DNA startsWithCDNA = DNA.string2DNA("CCGT");
    
    assertTrue("Two empty DNA are identical", emptyDNA.compareTo(emptyDNA) == 0);
    assertTrue("Shorter DNA is ordered first", shortDNA.compareTo(longDNA) < 0);
    assertTrue("Long DNA is ordered last", longDNA.compareTo(shortDNA) > 0);
    assertTrue("Same DNA are identical", longDNA.compareTo(longDNA) == 0);
    assertTrue("Ordered by alphabetical", startsWithCDNA.compareTo(shortDNA) > 0);
    assertTrue("Ordered by alphabetical", shortDNA.compareTo(startsWithCDNA) < 0);
    
  }
  
}