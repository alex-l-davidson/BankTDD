package org.sky.tdd;

import java.util.HashSet;
import java.util.Set;

public class BankSet {

    private Set<BankAccount> accounts = new HashSet<>();

    public BankSet(){
    }

    public boolean addAccount(BankAccount newBankAccount){
        if (accounts.contains(newBankAccount)){
            return false;
        } else {
            accounts.add(newBankAccount);
            return true;
        }
    }

    public boolean removeAccount(BankAccount accountToRemove){
        if (accounts.contains(accountToRemove)){
            accounts.remove(accountToRemove);
            return true;
        } else {
            return false;
        }
    }

    public BankAccount getAccount(int accountNumber){
        for (BankAccount ba : accounts){
            if (ba.getAccountNumber() == accountNumber){
                return ba;
        }
    }
        return null;
    }


}
