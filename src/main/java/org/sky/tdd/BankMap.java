package org.sky.tdd;

import java.util.HashMap;
import java.util.Map;

public class BankMap {
    Map<Integer, BankAccount> accounts = new HashMap<>();

    public boolean addAccount(BankAccount newAccount){
        if(accounts.containsKey(newAccount.getAccountNumber())){
            return false;
        } else {
            accounts.put(newAccount.getAccountNumber(), newAccount);
            return true;
        }
    }
}
