import org.junit.Assert;
import org.junit.Test;
import org.sky.tdd.BankAccount;

public class BankAccountTest {
    int accountNumber = 1;
    double balance = 1000;
    String accountName = "Bank Account";
    double newFunds = 1000;
    double fundsToRemove = 500;

    @Test
    public void CreateWithAllDetails(){
        BankAccount ba = new BankAccount(accountNumber, balance, accountName);

        Assert.assertEquals(balance, ba.getBalance(), 0.0001);
        Assert.assertEquals(accountNumber, ba.getAccountNumber());
        Assert.assertEquals(accountName, ba.getAccountName());
    }

    @Test
    public void CreateWithNoInputs(){
        BankAccount ba = new BankAccount();

        Assert.assertEquals(0, ba.getBalance(), 0.0001);
        Assert.assertEquals(BankAccount.AccountCounter, ba.getAccountNumber());
        Assert.assertEquals("Account " + accountNumber, ba.getAccountName());
    }
    @Test
    public void CreateWithAccountNumber(){
        BankAccount ba = new BankAccount(accountNumber);

        Assert.assertEquals(0, ba.getBalance(), 0.0001);
        Assert.assertEquals(accountNumber, ba.getAccountNumber());
        Assert.assertEquals("Account " + accountNumber, ba.getAccountName());
    }

    @Test
    public void CreateWithAccountNumberAndBalance(){
        BankAccount ba = new BankAccount(accountNumber, balance);

        Assert.assertEquals(balance, ba.getBalance(), 0.0001);
        Assert.assertEquals(accountNumber, ba.getAccountNumber());
        Assert.assertEquals("Account " + accountNumber, ba.getAccountName());
    }

    @Test
    public void AddFunds(){
        BankAccount ba = new BankAccount(accountNumber);
        ba.AddFunds(newFunds);
        Assert.assertEquals(newFunds, ba.getBalance(), 0.00001);
    }

    @Test
    public void RemoveFunds() throws Exception {
        BankAccount ba = new BankAccount(accountNumber, balance);
        ba.RemoveFunds(fundsToRemove);
        Assert.assertEquals(balance - fundsToRemove, ba.getBalance(), 0.00001);
    }

    @Test
    public void RemoveFundsFail(){
        BankAccount ba = new BankAccount(0, 0);
        boolean fails = false;
        try{
            ba.RemoveFunds(100);
        } catch (Exception e){
            Assert.assertEquals("You can't have minus funds!", e.getMessage());
            fails = true;
        }
        Assert.assertTrue(fails);
    }




}
