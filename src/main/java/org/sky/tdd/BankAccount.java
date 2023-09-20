package org.sky.tdd;

import java.util.Objects;

public class BankAccount {
    public static int AccountCounter;
    private int AccountNumber;
    private double Balance;
    private String AccountName;

    @Override
    public String toString() {
        return "BankAccount{" +
                "AccountNumber=" + AccountNumber +
                ", Balance=" + Balance +
                ", AccountName='" + AccountName + '\'' +
                '}';
    }

    public BankAccount(){
        this(AccountCounter++);
    }
    public BankAccount(int AccountNumber) {
        this(AccountNumber, 0);
    }

    public BankAccount (int accountNumber, double balance) {

        this(accountNumber, balance, "Account " + accountNumber);
    }

    public BankAccount(int accountNumber, double balance, String accountName) {
        this.AccountNumber = accountNumber;
        this.Balance = balance;
        this.AccountName = accountName;
    }

    public double AddFunds(double amount){
        this.Balance += amount;
        return this.Balance;
    }

    public double RemoveFunds(double amount) throws Exception{
        if (this.Balance - amount < 0){
            throw new Exception("You can't have minus funds!");
        }
        this.Balance -= amount;
        return this.Balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    void setBalance(double balance) {
        Balance = balance;
    }

    public String getAccountName() {
        return AccountName;
    }

    void setAccountName(String accountName) {
        AccountName = accountName;
    }

//    public String balanceReadOut() {
//        double numericBalance = getBalance();
//        String stringBalance = String.valueOf(numericBalance);
//        char[] arrayBalance = stringBalance.toCharArray();
//        System.out.println(arrayBalance);

    // if -
    // after .
    // by number of digits (groups of 3)
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return AccountNumber == that.AccountNumber && Double.compare(Balance, that.Balance) == 0 && Objects.equals(AccountName, that.AccountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountNumber);
    }
}
