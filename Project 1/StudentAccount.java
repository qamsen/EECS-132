/*Represents the financial accounts of a student. Divided into three parts: 
 * tuition, dining expense, and library fees.*/

public class StudentAccount extends Account{
  
  /*Student's name*/
  private String name;
  
  /*Student's living address*/
  private String address;
  
  /*Student's library account*/
  private LibraryAccount libAccount;
  
  /*Student's tuition account*/
  private CreditAccount tuitionAccount;
  
  /*Student's dining account*/
  private CreditAccount diningAccount;
  
  /*Student's refund amount*/
  private double refundAmount;
  
  /*Amount credited to the account*/
  private double credit;
  
  public StudentAccount(String number, String name) {
    super(number);
    this.name = name;
    
  }
  
  /*sets the name of the account owner*/
  public void setName(String name) {
    this.name = name;
  }
  
  /*returns the name of the account owner*/
  public String getName() {
    return name;
  }
  
  /*sets the address of the account owner*/
  public void setAddress(String address) {
    this.address = address;
  }
  
  /*returns the address of the account owner*/
  public String getAddress() {
    return address;
  }
  
  /*sets a library account to this account*/
  public void setLibraryAccount(LibraryAccount libAccount) {
    this.libAccount = libAccount;
  }
  
  /*returns the library account that is associated with this account*/
  public LibraryAccount getLibraryAccount() {
    return this.libAccount;
  }
  
  /*sets a credit account for tuition to this account*/
  public void setTuitionAccount(CreditAccount tuitionAccount) {
    this.tuitionAccount = tuitionAccount;
  }
  
  /*returns the tuition account that is associated with this account*/
  public CreditAccount getTuitionAccount() {
    return this.tuitionAccount;
  }
  
  /*sets a credit account for dining to this account*/
  public void setDiningAccount(CreditAccount diningAccount) {
    this.diningAccount = diningAccount;
  }
  
  /*returns the dining account that is associated with this account*/
  public CreditAccount getDiningAccount() {
    return this.diningAccount;
  }
  
  /*Gives the sum of balances in the library, dining, and library acccounts 
   * (if there is one)*/
  public double getBalance() {
    super.credit(super.getBalance());
    
    if (diningAccount != null) {
      super.charge(diningAccount.getBalance());
    }
    
    if (tuitionAccount != null) {
      super.charge(tuitionAccount.getBalance());
    }
    
    if (libAccount != null) {
      super.charge(libAccount.getBalance());
    }
    super.credit(refundAmount);
    return super.getBalance();
  }
  
  /*Charges the amount entered to the account. Subtracts the amount entered 
   * from the refund account, if the amount is positive the amount will be 
   * added to the tuition account. otherwise the refund amount is set to the 
   * difference. */
  public void charge(double charge) {
    if (charge - refundAmount > 0 && tuitionAccount != null) {
      tuitionAccount.charge(charge - refundAmount);
      refundAmount = 0;
    } else {
      refundAmount = -1 * (charge - refundAmount);
    }
    
  }
  
  /*Credits the amount entered to the account. Prioritizes tuition, then dining, 
   * the the library account. If all accounts are reduced to 0, then the 
   * remainder is added to the refund amount. */
  public void credit(double credit) {
    this.credit = credit;
    if (tuitionAccount != null) {
      double tuitionAccountDiff = tuitionAccount.getMonthlyPayment() - 
        tuitionAccount.getAmountPaidThisMonth();
      
      if (tuitionAccountDiff > 0) {
        if (this.credit > tuitionAccountDiff) {
          this.credit = this.credit - tuitionAccountDiff;
          tuitionAccount.credit(tuitionAccountDiff);
        } else {
          tuitionAccount.credit(this.credit);
          this.credit = 0;
        }
        
      }
      
    }
    
    if (diningAccount != null){
      double diningAccountDiff = diningAccount.getMonthlyPayment() - 
        diningAccount.getAmountPaidThisMonth();
      
      if (diningAccountDiff > 0) {
        if (this.credit > diningAccountDiff) {
          this.credit = this.credit - diningAccountDiff;
          diningAccount.credit(diningAccountDiff);
        } else {
          diningAccount.credit(this.credit);
          this.credit = 0;
        }
        
      }
      
    }
    
    if (libAccount != null && libAccount.getBalance() > 0) {
      if (this.credit > libAccount.getBalance()) {
        this.credit = this.credit - libAccount.getBalance();
        libAccount.credit(libAccount.getBalance());
      } else {
        libAccount.credit(this.credit);
        this.credit = 0;
      }
      
    }
    
    if (this.credit > 0) {
      refundAmount = refundAmount + this.credit;
      this.credit = 0;
    }
    
  }
  
}