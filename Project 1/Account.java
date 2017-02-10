/*Kameron Damaska
 * 
 * This class represents a general purpose account that recourds the amount of 
 * money an individual owes*/

import java.lang.Integer;

public class Account {
  
  /*Account number associate with the object, will never change*/
  private final String number;
  
  /*The balance of account*/
  private double balance;
  
  /*The amount charged to the account*/
  private double charge;
  
  /*The amount credited to the account*/
  private double credit;
  
  /*The balance limit for the acocunt*/
  private int balanceLimit;
  
  public Account(String number) {
    this.number = number;
  }
  
  public Account(String number, int balanceLimit) {
    this.number = number;
    this.balanceLimit = balanceLimit;
  }
  
  /*Returns the account number for the acccount*/
  public String getAccountNumber() {
    return number;
  }
  
  /*Returns the current balance of the account*/
  public double getBalance() {
    return this.balance;
  }
  
  /*Increases the balance by the amount charged*/
  public void charge(double charge) {
    this.balance = balance + charge;
  }
  
  /*Decreases the balanced by the amount credited*/
  public void credit(double credit) {
    this.balance = balance - credit;
  }
  
  /*Sets the balance limit of the account*/
  public void setBalanceLimit(int balanceLimit) {
    this.balanceLimit = balanceLimit;
  }
  
  /*Returns the balance limit of the account*/
  public int getBalanceLimit() {
    return balanceLimit;
  }
  
}