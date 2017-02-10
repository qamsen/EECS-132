import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked linked list.
 * 
 * @author Kameron Damaska
 */
public class DoubleLinkedList<T> implements Iterable<T> {
  /** a reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** a reference to the last node of a double linked list */
  private DLNode<T> back;
  
  /** Create an empty double linked list. */
  public DoubleLinkedList() {
    front = back = null;
  }
  
  /** 
   * Returns true if the list is empty.
   * 
   * @return  true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the linked list.
   * 
   * @return  the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }
  
  /**
   * Sets the first node of the linked list.
   * 
   * @param node  the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * 
   * @return  the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * 
   * @param  node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  }
  
  /**
   * Add an element to the head of the linked list.
   * 
   * @param element  the element to add to the front of the linked list
   */
  public void addToFront(T element) {
    /* When empty, the list consists of one node containing this element*/
    if(isEmpty()) {
      setFront(new DLNode<T>(element, null, null));
      setBack(getFront());
    }
    else {
      /* Stores the new node and the front of the new node*/
      DLNode<T> oldFront = this.getFront();
      DLNode<T> newFront = new DLNode<T>(element, null, oldFront);
      
      /* Sets the two to point to each other*/
      setFront(newFront);
      oldFront.setPrevious(newFront);
    }
  } 
  
  /**
   * Add an element to the tail of the linked list.
   * 
   * @param element  the element to add to the tail of the linked list
   */
  public void addToBack(T element) {
    /* When empty, the list consists of one node containing this element*/
    if(isEmpty()) {
      setFront(new DLNode<T>(element, null, null));
      setBack(this.getFront());
    }
    else {
      /* Stores the new node and the back of the new node*/
      DLNode<T> oldBack = this.getBack();
      DLNode<T> newBack = new DLNode<T>(element, oldBack, null);
      
      /* Sets the two to point to each other*/
      setBack(newBack);
      oldBack.setNext(newBack);
    }
  }
  
  /**
   * Compares if the content and length of the parameter
   * 
   * @param o  the object this DoubleLinkedList is compared to
   * @return   whether the object is equal in length and content to this
   *           DoubleLinkedList
   */
  @Override
  public boolean equals(Object o) {
    
    /* Checks if the object is a DoubleLinkedList*/
    if (o instanceof DoubleLinkedList) {
      DoubleLinkedList comparedList = (DoubleLinkedList) o;
      
      /* The element in the index node of this DoubleLinkedList*/
      DLNode indexNode1 = getFront();
      /* The element in the index node of the compared DoubleLinkedList*/
      DLNode indexNode2 = comparedList.getFront();
      
      
      /* Compares the two elements until the end of the list*/
      while (indexNode1 != null && indexNode2 != null) {
        
        /* Return false when the elements are not equal*/
        if (!indexNode1.getElement().equals(indexNode2.getElement())) {
          return false;
        }
        
        /* Move to the next node in each DoubleLinkedList*/
        indexNode1 = indexNode1.getNext();
        indexNode2 = indexNode2.getNext();
      }
      /* If both nodes are not null by the end, return false*/
      if (indexNode1 != indexNode2)
        return false;
      
      /* Otherwise, the lists are equal when the loop concludes*/
      return true;
    }
    return false;
  }
  
  /**
   * Appends a DoubleLinkedList to the end of this DoubleLinkedList
   * 
   * @param appended  The DoubleLinkedList appended to the end of this
   *                  DoubleLinkedList
   */
  public void append(DoubleLinkedList<T> appended) {
    /* When the parameter isn't empty, it will be appended*/
    if(!appended.isEmpty()) {
      
      /* The parameter becomes this DoubleLinkedList if this DoubleLinkedList
       * is empty*/
      if(isEmpty()) {
        setFront(appended.getFront());
        setBack(appended.getBack());
      }
      else {
        /* Sets the appended list to the back of this list*/
        getBack().setNext(appended.getFront());
        /* Sets this list behind the front of the appended list*/
        appended.getFront().setPrevious(getBack());
      }
    }
  }
  
  /**
   * Returns an interator for the linked list that starts at the head of the 
   * list and runs to the tail.
   * 
   * @return  the iterator that runs through the list from the head to the tail
   */
  @Override
  public ListIterator<T> iterator() {
    
    return new ListIterator<T>() {
      
      /* The node pointed at in the list*/
      private DLNode<T> currentNode = getFront();
      /* Returns if the set method can be used*/
      private boolean canSet = false;
      /* Node that stores last element returned by next or previous*/
      DLNode<T> storedNode;
      
      /**
       * Inserts the specified element into the list
       * 
       * @param t  The element added
       */
      @Override
      public void add(T element) {
        /* When there's zero elements in the list*/
        if (isEmpty()) {
          setFront(new DLNode<T>(element, null, null));
        }
        /* When the pointer is not at the front of the list*/
        else if(currentNode != getFront()) {
          /* Store the old previous*/
          DLNode<T> oldPrevious = currentNode.getPrevious();
          /* The new previous, with currentNode as next and oldPrevious as 
           * previous*/
          DLNode<T> newPrevious = new DLNode<T>(element, oldPrevious, 
                                                currentNode);
         
          /* The new previous is the previous for the current node and new for
           * the old previous*/
          currentNode.setPrevious(newPrevious);
          oldPrevious.setNext(newPrevious);
        }
        /* When the current node is the front*/
        else {
          DLNode<T> newPrevious = new DLNode<T>(element, null, currentNode);
          currentNode.setPrevious(newPrevious);
          setFront(newPrevious);
        }
        /* Set function can't be used*/
        canSet = false;
      }
      
      /**
       * Returns true if this list iterator has more elements when
       * traversing the list in the forward direction
       * 
       * @return  Whether there are more elements in the forward direction
       */
      @Override
      public boolean hasNext() {
        if (isEmpty())
          return false;
        
        return currentNode != null;
      }
      
      /**
       * Returns true if this iterator has more elements when
       * traversing the list in the reverse direction
       * 
       * @return Whether there are more elements in the reverse direction
       */
      @Override
      public boolean hasPrevious() {
        if(isEmpty())
          return false;
        
        return currentNode != null;
      }
      
      /**
       * Returns the next element in the list and advances the cursor
       * position
       * 
       * @throws NoSuchElementException  When there's no next element
       * @return                         The next element in the list
       */
      @Override
      public T next() throws NoSuchElementException{
        /* Throws exception if the previous element is null*/
        if (!hasNext())
          throw new NoSuchElementException();
        
        /* Stores the node*/
        storedNode = currentNode;
        
        /* Moves to next node in the list and returns the element in the node*/
        currentNode = currentNode.getNext();
        
        /* Sets method can be used*/
        canSet = true;
        
        return storedNode.getElement();
      }
      
      /**
       * Returns the previous element in the list moves the cursor position
       * backwards
       * 
       * @throws NoSuchElementException  When there is no previous element
       * @return                         The previous element in the list
       */
      @Override
      public T previous() throws NoSuchElementException {
        /* Throws exception if the previous element is null*/
        if (!hasPrevious())
          throw new NoSuchElementException();
        
        /* Stores the node*/
        storedNode = currentNode;
        
        /* Moves cursor to previous node in the list and returns the element*/
        currentNode = currentNode.getPrevious();
        
        /* Set method can be used*/
        canSet = true;
        
        return storedNode.getElement();
      }
      
      /**
       * Replaces the last element returned by next() or previous() with the
       * specified element. This call can be made only if add(E) had not been
       * called since the last next() or previous().
       * 
       * @param element                 The element replacing the element on the 
       *                                list.
       * @throws IllegalStateException  If neither next nor previous have been
       *                                called or add has been called after the
       *                                last call to next or previous.
       */
      @Override
      public void set(T element) {
        /* Throws exception when the element can't be set*/
        if(!canSet) {
          throw new IllegalStateException();
        }
        
        /* Node of the new element*/
        DLNode<T> newNode = new DLNode<T>(element, null, null);
        
        /* If the stored node has a previous node*/
        if (storedNode.getPrevious() != null) {
          /* Have the new node and the previous nodes point to eachother*/
          newNode.setPrevious(storedNode.getPrevious());
          storedNode.getPrevious().setNext(newNode);
        }
        else {
          /* The node is now the front of the list*/
          setFront(newNode);
        }
        
        /* If the stored node has a next node*/
        if (storedNode.getNext() != null) {
          newNode.setNext(storedNode.getNext());
          storedNode.getNext().setPrevious(newNode);
        }
        else {
          /* The node is now the back of the list*/
          setBack(newNode);
        }
      }
      
      /**
       * Unsupported method in this iterator
       * 
       * @throws  UnsupportedOperationException
       */
      @Override
      public int nextIndex() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      }
      
      /**
       * Unsupported method in this iterator
       * 
       * @throws  UnsupportedOperationException
       */
      @Override
      public int previousIndex() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      }
      
      /**
       * Unsupported method in this iterator
       * 
       * @throws  UnsupportedOperationException
       */
      @Override
      public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
      }
      
    };
    
  }
  
}