import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sky.tdd.Bank;
import org.sky.tdd.BankAccount;
import org.sky.tdd.BankSet;

public class BankSetTest {

    private BankSet bank;
    private BankAccount ba;

    @Before
    public void setup() {
        bank = new BankSet();
        ba = new BankAccount(1); //make a new account
        bank.addAccount(ba); //add it to the bank
    }

    @Test
    public void testAddAccount() {
        ba = new BankAccount(2); //make a new account
        boolean added = bank.addAccount(ba); //add it to the bank
        BankAccount found = bank.getAccount(2); //get the account we just made
        Assert.assertTrue(added); //addAccount returns true
        Assert.assertEquals(ba, found); //
    }

    @Test
    public void testAddDuplicateAccount() {
        ba = new BankAccount(1);
        boolean added = bank.addAccount(ba);
        Assert.assertFalse(added);
    }

    @Test
    public void testGetAccount() {
        BankAccount baGetTest = new BankAccount(5);
        bank.addAccount(baGetTest);
        BankAccount found = bank.getAccount(5);
        Assert.assertEquals(baGetTest, found);
    }

    @Test
    public void testRemoveAccount() {
        ba = bank.getAccount(1);
        boolean removed = bank.removeAccount(ba);
        BankAccount found = bank.getAccount(1);
        Assert.assertTrue(removed);
        Assert.assertNull(found);
    }

    @After
    public void cleanup() {
        bank = null;
        ba = null;
    }

}
