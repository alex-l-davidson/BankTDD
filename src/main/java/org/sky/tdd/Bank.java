package org.sky.tdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private List<BankAccount> Accounts = new ArrayList<BankAccount>();
    public Bank() {
    }
    public BankAccount findAccount(int AccountNumber) {
        BankAccount found = null;
        for (BankAccount ba : Accounts) {
            if (ba.getAccountNumber() == AccountNumber) {
                found = ba;
                break;
            }
        }
        return found;
    }
    public void addAccount(BankAccount newBankAccount) throws Exception {
        for (int i = 0; i < Accounts.size(); i++) {
            if (Accounts.get(i) == newBankAccount ||
                    Accounts.get(i).getAccountNumber() == newBankAccount.getAccountNumber()) {
                throw new Exception("This account already exists with this bank");
            }
        }
        Accounts.add(newBankAccount);
    }

    public List<BankAccount> getAllAccounts() {
        return Accounts;
    }
    public BankAccount getAccountByIndex(int i) {
        if (i < 0 || i > Accounts.size()){
            return null;
        }
        return Accounts.get(i);
    }
    public void printAllAccounts() {
        for (BankAccount a : Accounts) {
            System.out.println(a);
        }
    }
    public BankAccount removeAccountByIndex(int i) {
        if (i < 0 || i > Accounts.size()) return null;
        return Accounts.remove(i);
    }
    public BankAccount removeAccountByAccountNumber(int accountNumber) {
        BankAccount removed = findAccount(accountNumber);
        Accounts.remove(removed);
        return removed;
    }
    public BankAccount[] getAccountsArray() {
        return Accounts.toArray(BankAccount[]::new);
        // array constructor
    }
    public double getAvgBalance() {
        double total = 0;
        for (BankAccount ba : Accounts) {
            total += ba.getBalance();
        }
        return total / Accounts.size();
    }
}
