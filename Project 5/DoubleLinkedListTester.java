import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A class that tests the methods of the DoubleLinkedList class.
 * 
 * @author Kameron Damaska
 */
public class DoubleLinkedListTester {
  
  /**
   * Tests the addToFront method of DoubleLinkedList.
   */
  @Test
  public void testAddToFront() {
    
    /* List tests will be done on*/
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    
    /* Initializes the list*/
    for(int i = 3; i > 0; i--) {
      list.addToFront(i);
    }
    
    /* Stores the front and back of the list*/
    DLNode<Integer> head = list.getFront();
    DLNode<Integer> tail = list.getBack();
    
    assertEquals("Testing first node of list", new Integer(1), head.getElement());
    assertEquals("Testing second node of list", new Integer(2), head.getNext().getElement());
    assertEquals("Testing third node of list", new Integer(3), head.getNext().getNext().getElement());
    assertEquals("Testing end of list", null, head.getNext().getNext().getNext());
    
    assertEquals("Testing node at back of list", new Integer(3), tail.getElement());
    assertEquals("Testing next to last node", new Integer(2), tail.getPrevious().getElement());
    assertEquals("Testing third to last node", new Integer(1), tail.getPrevious().getPrevious().getElement());
    assertEquals("Testing front of list", null, tail.getPrevious().getPrevious().getPrevious());
  }

  /**
   * Tests the addToBack method of DoubleLinkedList.
   */
  @Test
  public void testAddToBack() {
    
    /* List tests will be done on*/
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    
    /* Initializes the list*/
    for (int i = 1; i <= 3; i++) {
      list.addToBack(i);
    }
    
    /* Stores the front and back of the list*/
    DLNode<Integer> head = list.getFront();
    DLNode<Integer> tail = list.getBack();
      
    assertEquals("Testing last node of list", new Integer(3), tail.getElement());
    assertEquals("Testing next to last node", new Integer(2), tail.getPrevious().getElement());
    assertEquals("Testing third to last node", new Integer(1), tail.getPrevious().getPrevious().getElement());
    assertEquals("Testing front of list", null, tail.getPrevious().getPrevious().getPrevious());
    
    assertEquals("Testing node at front of list", new Integer(1), head.getElement());
    assertEquals("Testing second node of list", new Integer(2), head.getNext().getElement());
    assertEquals("Testing third node of list", new Integer(3), head.getNext().getNext().getElement());
    assertEquals("Testing end of list", null, head.getNext().getNext().getNext());
  }
  
  /**
   * Tests the equals method of DoubleLinkedList.
   */
  @Test
  public void equals() {
    
    /* The test every other list will be compared to*/
    DoubleLinkedList<Integer> testList    = new DoubleLinkedList<Integer>();
    
    /* Initializes the test list*/
    for (int i = 4; i > 0; i--) {
      testList.addToFront(i);
    }
    
    /* A list that differs in length*/
    DoubleLinkedList<Integer> unequalList = new DoubleLinkedList<Integer>();
    
    /* Initializes the differing length list*/
    for (int i = 5; i > 0; i--) {
      unequalList.addToFront(i);
    }
    
    /* A list that is equal in length and content to the test list*/
    DoubleLinkedList<Integer> equalList   = new DoubleLinkedList<Integer>();
    
    /* Initializes the equal list*/
    for (int i = 4; i > 0; i--) {
      equalList.addToFront(i);
    }
    
    /* A list that contains a different type*/
    DoubleLinkedList<Integer> emptyList   = new DoubleLinkedList<Integer>();
    
    /* An empty list*/
    DoubleLinkedList<Double> doubleList   = new DoubleLinkedList<Double>();
    
    /* Initializes the differing type list*/
    for (double d = 4.0; d > 0; d--) {
      doubleList.addToFront(d);
    }
    
    assertFalse("non-DoubleLinkedList test", testList.equals(new Object()));
    assertFalse("Differing types test", testList.equals(doubleList));
    assertFalse("Differing length test", testList.equals(unequalList));
    
    assertTrue("Equal list test", testList.equals(equalList));
    assertTrue("Two empty lists", emptyList.equals(emptyList));
  }
  
  /**
   * Tests the append method of DoubleLinkedList
   */
  @Test
  public void testAppend() {
    
    /* The list being tested on*/
    DoubleLinkedList<Integer> testList     = new DoubleLinkedList<Integer>();
    
    /* Initialize the list*/
    for (int i = 1; i <= 5; i++) {
      testList.addToBack(i);
    }
    
    /* The not-empty list being appended*/
    DoubleLinkedList<Integer> appendedList = new DoubleLinkedList<Integer>();
    
    /* Initialize the list*/
    for (int i = 6; i <= 10; i++) {
      appendedList.addToBack(i);
    }
    
    /* A list that should be the result of the second list being appended to the
     * first*/
    DoubleLinkedList<Integer> fullList     = new DoubleLinkedList<Integer>();
    
    /* Initialize the list*/
    for (int i = 1; i <= 10; i++) {
      fullList.addToBack(i);
    }
    
    /* An empty list*/
    DoubleLinkedList<Integer> emptyList    = new DoubleLinkedList<Integer>();
    
    /* Appending the second half fullList to the first half*/
    testList.append(appendedList);
    
    assertTrue("testList equals fullList", testList.equals(fullList));
    
    /* Appending emptyList to testList*/
    testList.append(emptyList);
    
    assertTrue("appending emptyList doesn't change testList", 
               testList.equals(testList));
    
    /* Storing the current emptyList and appending emptyList to emptyList*/
    DoubleLinkedList<Integer> oldEmptyList = emptyList;
    emptyList.append(emptyList);
    
    assertTrue("appending emptyList doesn't change emptyList",
               oldEmptyList.equals(emptyList));
    
    /* Appending the testList to emptyList*/
    emptyList.append(testList);
    
    assertTrue("emptyList now equals testList", emptyList.equals(testList));
  }

  /**
   * Tests the iterator method of DoubleLinkedList
   */
  @Test
  public void testIterator() {
    
    /* A test list*/
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    
    /* Initializes the list*/
    for (int i = 1; i <= 3; i++) {
      list.addToBack(i);
    }
    
    /* the test list iterator*/
    ListIterator<Integer> listIterator = list.iterator();
    
    /* An empty test list and its iterator*/
    DoubleLinkedList<Integer> emptyList = new DoubleLinkedList<Integer>();
    ListIterator<Integer> emptyListIterator = emptyList.iterator();
    
    /* Testing hasNext and next*/
    assertTrue("list has a next node", listIterator.hasNext());
    assertEquals("the element return is 1", new Integer(1), listIterator.next());
    assertTrue("list has a next node", listIterator.hasNext());
    assertEquals("the element return is 2", new Integer(2), listIterator.next());
    assertTrue("list has a next node", listIterator.hasNext());
    assertEquals("the element return is 3", new Integer(3), listIterator.next());
    assertFalse("list has no next node", listIterator.hasNext());
    
    /* Stores if an error is found*/
    boolean caughtError = false;
    
    /* Tries the error*/
    try {
      listIterator.next();
    }
    catch (NoSuchElementException e) {
      caughtError = true;
    }
    
    assertTrue("An error is thrown", caughtError);
    caughtError = false;
    
    /* Tries the error on emptyList*/
    try {
      emptyListIterator.next();
    }
    catch (NoSuchElementException e) {
      caughtError = true;
    }
    
    assertTrue("An error is thrown", caughtError);
    caughtError = false;
    
    
    /* the test list iterator*/
    listIterator = list.iterator();
    
    /* Sets the pointer to the back*/
    listIterator.next();
    listIterator.next();
    
    /* Testing hasPrevious and previous*/
    assertTrue("list has a previous node", listIterator.hasPrevious());
    assertEquals("the return element is 3", new Integer(3), 
                                              listIterator.previous());
    assertTrue("list has a previous node", listIterator.hasPrevious());
    assertEquals("the return element is 2", new Integer(2), 
                                              listIterator.previous());
    assertEquals("the return element is 1", new Integer(1), 
                                              listIterator.previous());
    assertFalse("list has no previous node", listIterator.hasPrevious());
    
    /* Tries the error*/
    try {
      listIterator.previous();
    }
    catch (NoSuchElementException e) {
      caughtError = true;
    }
    
    assertTrue("An error is thrown", caughtError);
    caughtError = false;
    
    /* Tries the error on emptyList*/
    try {
      emptyListIterator.previous();
    }
    catch (NoSuchElementException e) {
      caughtError = true;
    }
    
    assertTrue("An error is thrown", caughtError);
    caughtError = false;
    
    
    /* Testing the add method*/
    
    /* The list add will be tested on*/
    DoubleLinkedList<Integer> countToFive = new DoubleLinkedList<Integer>();
    
    /* Initalizes the list*/
    countToFive.addToBack(1);
    countToFive.addToBack(2);
    countToFive.addToBack(5);
    
    /* Iterator for countToFive*/
    ListIterator<Integer> countToFiveIterator = countToFive.iterator();
    
    /* adding an element to an empty list*/
    emptyListIterator.add(1);
    
    assertEquals("The only element is 1", new Integer(1), 
                                          emptyList.getFront().getElement());
    
    /* Move pointer to second element*/
    countToFiveIterator.next();
    countToFiveIterator.next();
    
    /* adding an element to the end of a list*/
    countToFiveIterator.add(4);
    
    /* Moves pointer to the previous*/
    countToFiveIterator.previous();
    
    assertEquals("The previous element is 4", new Integer(4),
                                              countToFiveIterator.previous());
    
    /* Set the pointer to 2*/
    countToFiveIterator.previous();
    
    /* adding an element at some point in the middle of the list*/
    countToFiveIterator.add(3);
    
    /* Moves pointer to the previous*/
    countToFiveIterator.previous();
    
    assertEquals("The previous element is 3", new Integer(3),
                                              countToFiveIterator.previous());
    
    /* Setting countToFiveIterator back to the front*/
    countToFiveIterator = countToFive.iterator();
    
    /* adding an element at the start of the list*/
    countToFiveIterator.add(0);
    
    /* Moves pointer to the previous*/
    countToFiveIterator.previous();
    
    assertEquals("The previous element is 0", new Integer(0),
                                              countToFiveIterator.previous());
    
    /* Setting countToFiveIterator back to the front*/
    countToFiveIterator = countToFive.iterator();
    
    /* Moves to next*/
    countToFiveIterator.next();
    
    /* Testing the set method*/
    countToFiveIterator.set(-1);
    countToFiveIterator.next();
    countToFiveIterator.set(-2);
    
    /* Setting pointer*/
    countToFiveIterator = countToFive.iterator();
    

    assertEquals("The element returned should be -1", new Integer(-1),
                                               countToFiveIterator.next());
    assertEquals("The element returned should be -2", new Integer(-2),
                                                   countToFiveIterator.next());
    
    /* Trying to set after add has been used*/
    countToFiveIterator.add(-5);
    
    try {
      countToFiveIterator.set(4);
    }
    catch (IllegalStateException e) {
      caughtError = true;
    }
    
    assertTrue("An error was caught", caughtError);
    caughtError = false;
    
    /* Trying to set on a list where next and previous haven't been used*/
    DoubleLinkedList<Integer> emptyList1 = new DoubleLinkedList<Integer>();
    ListIterator<Integer> emptyListIterator1 = emptyList1.iterator();
    
    try {
      emptyListIterator1.set(0);
    }
    catch (IllegalStateException e) {
      caughtError = true;
    }
    
    assertTrue("An error was caught", caughtError);
  }
  
}