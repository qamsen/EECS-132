/*This class represent a customer's account for borrowing money and penalties 
 * associated with late payments*/

public class CreditAccount extends Account{
  
  /*The interest rate of the account*/
  private double interestRate;
  
  /*The amount owed this month*/
  private double monthlyPayment;
  
  /*The amount credited to this account this month*/
  private double amountPaid;
  
  public CreditAccount(String number, double interestRate) {
    super(number);
    this.interestRate = interestRate;
    
  }
  
  /*Sets the interest rate of the account*/
  public void setInterestRate (double interestRate) {
    this.interestRate = interestRate;
    
  }
  
  /*Returns the set interest rate for the acccount*/
  public double getInterestRate() {
    return this.interestRate;
    
  }
  
  /*Returns the amount that must be paid this month to avoid an interest 
   * charge*/
  public double getMonthlyPayment() {
    return monthlyPayment;
    
  }
  
  /*The amount that has been credited to the account this month*/
  public double getAmountPaidThisMonth() {
    return amountPaid;
    
  }
  
  /*Increases the balance of the account by the amount of interest charged, 
   * starts a new month*/
  public void endOfMonth() {
    if (monthlyPayment > amountPaid) {
      charge(getBalance() * interestRate / 12);
    }
    monthlyPayment = getBalance();
    amountPaid = 0;
  }
  
  /*Decreases the account balance and increases the amount paid this month by 
   * the input value*/
  public void credit(double credit) {
    super.credit(credit);
    this.amountPaid = amountPaid + credit;
  }
  
}