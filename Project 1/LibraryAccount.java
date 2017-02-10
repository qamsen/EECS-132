/*The class is the financial record of an individual at a library. It records 
 * any overdue meterial and any fine towards the individual*/

public class LibraryAccount extends Account {
  
  /*Amount charged daily for an overdue book*/
  private double bookFine;
  
  /*Amount charged daily for a reserved book that is overdue*/
  private double reserveFine;
  
  /*Number of overdue books*/
  private int overdue = 0;
  
  /*Number of overdue reserved books*/
  private int reserveOverdue = 0;
  
  public LibraryAccount(String number) {
    super(number);
  }
  
  public LibraryAccount(String number, int balanceLimit, double bookFine, 
                        double reserveFine) {
    super(number, balanceLimit);
    this.bookFine = bookFine;
    this.reserveFine = reserveFine; 
  }
  
  /*Sets the amount an individual will be fined each day for an overdue book*/
  public void setBookFine(double bookFine) {
    this.bookFine = bookFine;
  }
  
  /*Returns the amount an individual will be fined for each day a book is late*/
  public double getBookFine() {
    return this.bookFine;
  }
  
  /*Sets the amount an individual will be fined each day a reserved book is 
   * overdue*/
  public void setReserveFine(double reserveFine) {
    this.reserveFine = reserveFine;
  }
  
  /*Returns the amount an individual will be fined each day a reserved book is 
   * overdue*/
  public double getReserveFine(){
    return this.reserveFine;
  }
  
  /*Increases the number of overdue books on this account by one*/
  public void incrementOverdueBooks() {
    this.overdue = overdue + 1;
  }
  
  /*Decreases the number of overdue books on this account by one*/
  public void decrementOverdueBooks() {
    if (this.overdue - 1 >= 0) {
      this.overdue = overdue - 1;
    } else {
      this.overdue = overdue;
    }
  }
  
  /*Recalls the number of overdue books on this account*/
  public int getNumberOverdueBooks() {
    return overdue;
  }
  
  /*Increases the number of overdue reserved books on this account by one*/
  public void incrementOverdueReserve() {
    this.reserveOverdue = reserveOverdue + 1;
  }
  
  /*Decreases the number of overdue reserved books on this account by one*/
  public void decrementOverdueReserve() {
    if (this.reserveOverdue - 1 >= 0) {
      this.reserveOverdue = reserveOverdue - 1;
    } else {
      this.reserveOverdue = reserveOverdue;
    }
  }
  
  /*Recalls the number of overdue reserved books on this account by one*/
  public int getNumberOverdueReserve() {
    return reserveOverdue;
  }
  
  /*Says whether or not the account can borrow a book*/
  public boolean canBorrow() {
    if (this.getBalanceLimit() >= this.getBalance()) {
      return true;
    } else {
      return false;
    }
  }
  
  /*Increases the account balance by the amount fined due to late books*/
  public void endOfDay() {
    this.charge(bookFine * overdue + reserveFine * reserveOverdue);
  }
  
}