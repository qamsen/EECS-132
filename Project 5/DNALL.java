import java.util.*;
public class DNALL extends LinkedList<DNALL.Base> {
  
  public enum Base {
    /* The four possible bases*/
    A ("A"), C ("C"), G ("G"), T ("T");
    
    /* Stores the base as a String*/
    private String base;
    
    /**
     * Creates the Base object
     * 
     * @param base  the base as a String
     */
    private Base(String base) {
      this.base = base;
    }
    
  }
  
  public DNALL() {
  }
  
  /**
   * Returns a String representation of the DNA sequence
   * 
   * @return a String representation of the DNA sequence
   */
  public String toString() {
    
    /* The DNA as a StringBuilder*/
    StringBuilder dna = new StringBuilder();
    
    /* Appends each Base in this DNA*/
    for(Base b : this) {
      dna.append(b);
    }
    
    return dna.toString();
  }
  
  /**
   * Returns the Character as a Base
   * 
   * @param c                          the Character in question
   * @return                           the Character as a Base
   * @throws IllegalArgumentException  if the Character is not a base
   */
  private static Base charToBase(Character c) throws IllegalArgumentException {
    /* Returns the respective base. If not a base, throw an error*/
    if (c == 'A')
      return Base.A;
    else if (c == 'C')
      return Base.C;
    else if (c == 'G')
      return Base.G;
    else if (c == 'T')
      return Base.T;
    /* Throws error when the Character does not represent a base*/
    else
      throw new IllegalArgumentException();
  }
  
  /**
   * Returns the String parameter as a class DNA
   * 
   * @param s                          the String that represents DNA
   * @return                           the String as a DNA
   * @throws IllegalArgumentException  if the String does not represent DNA
   */
  public static DNALL string2DNA(String s) throws IllegalArgumentException {
    /* Throws error when the String is empty*/
    if (s.length() == 0)
      throw new IllegalArgumentException();
    
    /* Will store the DNA equivalent of the String parameter*/
    DNALL stringDNA = new DNALL();
    /* Stores the String as a char array*/
    char[] charArray = s.toCharArray();
    
    /* Add each char to the DNA, unless it does not represent a base*/
    for (Character c : charArray) {
      stringDNA.addLast(charToBase(c));
    }
    
    /* Return the String as DNA*/
    return stringDNA;
  }
  
  /**
   * Returns whether the last n bases of dna1 exactly match the first n bases
   * of dna2
   * 
   * @param dna1  The dna strand checked from the back
   * @param dna2  The dna strand checked from the front
   * @param n     How far the overlap is checked
   * @return      Whether they last n bases of dna1 match the first n bases of
   *              dna2
   */
  public static boolean overlaps(DNALL dna1, DNALL dna2, int n) {
    
    /* A new DNA that will store dna1 in reverse*/
    DNA dna1Reverse = new DNA();
    
    /* The index node of dna1*/
    DLNode<Base> indexDNA = dna1.getFront();
    
    while (indexNode != null) {
      dna1Reverse.addToFront(indexNode);
      indexNode = indexNode.getNext();
    }
    
    /* Stores iterators for dna2 and the reverse of dna1*/
    ListIterator dna2Iterator = dna2.listIterator();
    ListIterator dna1Iterator = dna1Reverse.iterator();
    
    /* Loops through n bases of dna1 and dna2 to see if they match*/
    for(int i = 0; i < n; i++) {
      /* If it goes out of bounds, they don't overlap*/
      if (outOfBounds(dna1Iterator, dna2Iterator)) {
        return false;
      }
      /* If the elements don't match, they don't overlap*/
      else if (dna1Iterator.previous() != dna2Iterator.next()) {
        return false;
      }
    }
    return true;
  }
  
}