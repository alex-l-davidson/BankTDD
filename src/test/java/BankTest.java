import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.runner.notification.RunListener;
import org.sky.tdd.Bank;
import org.sky.tdd.BankAccount;

public class BankTest {
    private Bank bank;
    private BankAccount ba;
    private int newAccountNum = 4; // must be > 3 as three are created in SetUp
    private double newBalance = 2000;
    private int findAccountNum = 1; //

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setupBank() throws Exception{

        bank = new Bank();

        BankAccount ba1 = new BankAccount(1);

        bank.addAccount(ba1);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void addAccount() throws Exception{
        BankAccount ba4 = new BankAccount(newAccountNum, newBalance);
        bank.addAccount(ba4);

        ba = bank.findAccount(newAccountNum);

        Assert.assertEquals(newAccountNum, ba.getAccountNumber());
        Assert.assertEquals(newBalance, ba.getBalance(), 0.00001);
        Assert.assertEquals("Account " + newAccountNum, ba.getAccountName());

    }

    @Test
    public void exceptionOnDuplicate() throws Exception{
        ba = bank.findAccount(1);

        try{
            bank.addAccount(ba);
            Assert.fail("Exception not called");
        } catch (Exception e){
            Assert.assertEquals("This account already exists with this bank",
                    e.getMessage());
        }
    }

    @Test
    public void findAccount(){

        ba = bank.findAccount(findAccountNum);

        Assert.assertEquals(findAccountNum, ba.getAccountNumber());

    }

    @Test
    public void getAllAccounts(){
        List<BankAccount> accounts = bank.getAllAccounts();
        Assert.assertEquals(accounts.get(0), new BankAccount(1));
    }

    @Test
    public void getAccountByIndex() throws Exception{
        ba = new BankAccount(2);
        bank.addAccount(ba);
        Assert.assertEquals(ba, bank.getAccountByIndex(1));

    }

    @Test
    public void printAllAccounts(){
        bank.printAllAccounts();
        String actual = outputStreamCaptor.toString().trim();
        Assert.assertEquals("BankAccount{AccountNumber=1, Balance=0.0, AccountName='Account 1'}",
                actual);
    }
//  @Test
//    public void removeAccountByIndex(){
//        BankAccount removed = bank.getAccountByIndex(0);
//        bank.removeAccountByIndex(0);
//      Assert.assertNull(bank.getAccountByIndex(0));
//    }

    @Test
    public void removeAccountByAccountNumber(){
        BankAccount deleted = bank.removeAccountByAccountNumber(1);
        Assert.assertEquals(new BankAccount(1),deleted);
    }


    @Test
    public void getAccountsArray() {

    }

    @Test
    public void getAvgBalance()throws Exception{
        BankAccount ba2 = new BankAccount(2, 100);
        BankAccount ba3 = new BankAccount(3, 200);
        bank.addAccount(ba2);
        bank.addAccount(ba3);
        double actualAvg = bank.getAvgBalance();
        Assert.assertEquals(100, actualAvg, 0.00001);
    }

    @After
    public void cleanUp(){
        bank = null;
        ba = null;
        System.setOut(standardOut);
    }

}
