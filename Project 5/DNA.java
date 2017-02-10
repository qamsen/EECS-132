import java.util.*;
/**
 * A class that represents DNA
 * 
 * @author Kameron Damaska
 */
public class DNA extends DoubleLinkedList<DNA.Base> implements Comparable<DNA> {
  
  /* Enum classes that represent Bases, which make up the DNA*/
  public enum Base {
    /* The four possible bases*/
    A('A'), C('C'), G('G'), T('T');
    
    private char base;
    
    private Base (char base) {
      this.base = base;
    }
    
    public char getBase() {
      return base;
    }
    
  }
  
  /* Calls DoubleLinkedList's constructor*/
  public DNA() {
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
  public static DNA string2DNA(String s) throws IllegalArgumentException {
    /* Throws error when the String is empty*/
    if (s.length() == 0)
      throw new IllegalArgumentException();
    
    /* Will store the DNA equivalent of the String parameter*/
    DNA stringDNA = new DNA();
    /* Stores the String as a char array*/
    char[] charArray = s.toCharArray();
    
    /* Add each char to the DNA, unless it does not represent a base*/
    for (Character c : charArray) {
      stringDNA.addToBack(charToBase(c));
    }
    
    /* Return the String as DNA*/
    return stringDNA;
  }
  
  /**
   * Removes bases from the start of DNA and append the remaining bases to
   * this DNA
   * 
   * @param dna       the DNA being spliced
   * @param numbases  the number of bases removed from the front
   */
  public void splice(DNA dna, int numbases) {
    /* If dna is empty, then nothing is appended*/
    if(!dna.isEmpty()) {
      
      /* Stores the first node of the parameter DNA*/
      DLNode<Base> removeNodes = dna.getFront();
      
      /* The DNA that will be appended*/
      DNA appendedDNA = new DNA();
      
      /* Finds the Node at length numbases*/
      for (int i = 0; i < numbases; i++) {
        if(removeNodes != null)
          removeNodes = removeNodes.getNext();
      }
      
      
      /* Sets the front and back of the appended DNA*/
      appendedDNA.setFront(removeNodes);
      appendedDNA.setBack(dna.getBack());
      
      /* appends the spliced dna to this dna*/
      append(appendedDNA);
    }
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
  public static boolean overlaps(DNA dna1, DNA dna2, int n) {
    
    /* The number of elements in dna1 and dna2*/
    int dna1Length = 0;
    int dna2Length = 0;
    
    /* Iterators for both dna*/
    ListIterator dna1Iterator = dna1.iterator();
    ListIterator dna2Iterator = dna2.iterator();
    
    /* Counts the elements in dna1*/
    for (Base b : dna1) {
      dna1Length++;
    }
    
    /* Counts the elements in dna2*/
    for (Base b : dna2) {
      dna2Length++;
    }
    
    /* Returns false if n is greater than the length of either dna*/
    if (dna1Length < n || dna2Length < n) {
      return false;
    }
    
    /* Sets the pointer to where the comparison will happen*/
    for(int i = 0; i < dna1Length - n; i++) {
      dna1Iterator.next();
    }
    
    /* Compares n elements in the DNA strands*/
    for (int i =  0; i < n; i++) {
      if (dna1Iterator.next() != dna2Iterator.next()) {
        return false;
      }
      
    }
    return true;
  }
  
  /**
   * Takes two String parameters and splices the DNA to form the shortest DNA
   * possible without loss of information
   * 
   * @param args  The parameters for the method
   */
  public static void main(String[] args) {
    
    /* Checks whether the method will continue to be executed*/
    boolean continueMethod = true;
    
    /* There must be 2 parameters*/
    if (args.length != 2) {
      System.out.println("Please enter two DNA sequences");
      continueMethod = false;
    }
    if (continueMethod) {
      /* Catch any inputs that cannot be represented as DNA*/
      try {
        DNA dna1 = DNA.string2DNA(args[0]);
        DNA dna2 = DNA.string2DNA(args[1]);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Please enter two DNA sequences");
        continueMethod = false;
      }
    }
    if (continueMethod) {
      
      /* Stores each parameter as a DNA*/
      DNA dna1 = DNA.string2DNA(args[0]);
      DNA dna2 = DNA.string2DNA(args[1]);
      
      /* Stores iterators for both DNA*/
      ListIterator dna1Iterator = dna1.iterator();
      ListIterator dna2Iterator = dna2.iterator();
      
      /* Overlap between back of the dna1 and front of dna2*/
      int firstOverlap = 0;
      /* Overlap between back of the dna2 and front of dna1*/
      int secondOverlap = 0;
      /* If there's overlap at value n*/
      boolean overlap = false;
      
      /* Checks if there's overlap*/
      int overlapAt = 0;
      
      /* Finds the value at which dna1 has largest overlap over dna2*/
      while (dna1Iterator.hasNext() && dna2Iterator.hasNext()) {
        
        overlapAt++;
        
        /* Checks if there's overlap at the increment of firstOverlap*/
        overlap = DNA.overlaps(dna1, dna2, overlapAt);
        
        /* Increment if the incremenet has overlap*/
        if (overlap) {
          firstOverlap = overlapAt;
        }
        
        /* Moves pointer, loop continues until the iterator exceeds the length of 
         * DNAs*/
        dna1Iterator.next();
        dna2Iterator.next();
      }
      
      /* Resets iterators and overlapAt*/
      dna1Iterator = dna1.iterator();
      dna2Iterator = dna2.iterator();
      overlapAt = 0;
      
      /* Checks for largests overlap of dna2 over dna1*/
      while (dna1Iterator.hasNext() && dna2Iterator.hasNext()) {
        
        overlapAt++;
         
        /* Checks if there's overlap at the increment of firstOverlap*/
        overlap = DNA.overlaps(dna2, dna1, overlapAt);
        
        /* Increment if the incremenet has overlap*/
        if (overlap) {
          secondOverlap = overlapAt;
        }
        
        /* Moves pointer, loop continues until the iterator exceeds the length of 
         * DNAs*/
        dna1Iterator.next();
        dna2Iterator.next();
      }
      
      /* If the first overlap is larger, append the spliced dna2 to dna1*/
      if (firstOverlap >= secondOverlap) {
        dna1.splice(dna2, firstOverlap);
        System.out.println(dna1.toString());
      }
      /* If second overlap is larger, append the spliced dna1 to dna2*/
      else {
        dna2.splice(dna1, secondOverlap);
        System.out.println(dna2.toString());
      }
      
    }
    
  }
  
  /**
   * Compares this DNA to the specified DNA. Negative values means this DNA is 
   * ordered first, positive values means this DNA is last. 0-value means they
   * are identical. Comparisons are first made by length, then by alphabetical.
   * 
   * @param dna  The DNA this DNA is compared to
   * @return     The order of the DNA
   */
  @Override
  public int compareTo(DNA dna) {
    
    /* Stores the length of each DNA*/
    int thisDNALength = 0;
    int paramDNALength = 0;
    
    /* Iterator for this DNA*/
    ListIterator<DNA.Base> thisIterator = iterator();
    
    /* Stores which DNA strand is first alphabetically*/
    int alphabeticalOrder = 0;
    
    /* Stores whether the alphabetically order has been found*/
    boolean orderFound = false;
    
    /* Index base for this DNA*/
    DNA.Base thisDNAIndex;
    
    /* Checks each Base in the dna parameter*/
    for (DNA.Base b : dna) {
      
      if (thisIterator.hasNext()) {
        
        /* Moves the pointer on this dna*/
        thisDNAIndex = thisIterator.next();
        
        /* While the alphabetically order is not found*/
        if (!orderFound) {
          
          /* Checks if the elements are different*/
          if(b != thisDNAIndex) {
            
            /* Stores the difference between the elements*/
            alphabeticalOrder = thisDNAIndex.getBase() - b.getBase();
            orderFound = true;
          }
        }
        
        /* Increments the recorded length of the parameter dna*/
        paramDNALength++;
      }
      
      /* Increments the recorded length of this dna*/
      thisDNALength++;
    }
    
    /* Stores the difference in length*/
    int lengthDifference = thisDNALength - paramDNALength;
    
    /* If this dna has a greater length than the parameter, return 1*/
    if (thisIterator.hasNext()) {
      return 1;
    }
    /* Otherwise, if the difference is not 0 it will be negative*/
    if (lengthDifference != 0) {
      return -1;
    }
    /* Otherwise, use the alphabetically order found*/
    else {
      return alphabeticalOrder;
    }
  }
  
}