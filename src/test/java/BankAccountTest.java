
import org.example.BankAccount;
import org.example.BankAccountActionInvalidException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;

import static junit.framework.TestCase.fail;


public class BankAccountTest {
    private BankAccount bankAccount = new BankAccount();

    @Test
    public void newlyOpenedAccountHasEmptyBalance() throws BankAccountActionInvalidException {
        bankAccount.open();
        Assert.assertEquals(bankAccount.getBalance(), (0));
    }

    @Test
    public void canDepositMoney() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        Assert.assertEquals(bankAccount.getBalance(), (10));
    }

    @Test
    public void canDepositMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(5);
        bankAccount.deposit(23);
        Assert.assertEquals(bankAccount.getBalance(), (28));
    }

    @Test
    public void canWithdrawMoney() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        bankAccount.withdraw(5);
        Assert.assertEquals(bankAccount.getBalance(), (5));
    }

    @Test
    public void canWithdrawMoneySequentially() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(23);
        bankAccount.withdraw(10);
        bankAccount.withdraw(13);
        Assert.assertEquals(bankAccount.getBalance(), (0));
    }

    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotWithdrawMoneyFromEmptyAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.withdraw(5);
    }


    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotWithdrawMoreMoneyThanYouHave() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(6);
        bankAccount.withdraw(7);
    }

    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotDepositNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(-1);
    }

    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotWithdrawNegativeAmount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(105);
        bankAccount.withdraw(-5);
    }

    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotGetBalanceOfClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(10);
        bankAccount.close();
        bankAccount.getBalance();
    }
    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotDepositMoneyIntoClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.close();
        bankAccount.deposit(5);
    }
    @Test(expected = BankAccountActionInvalidException.class)
    public void cannotWithdrawMoneyFromClosedAccount() throws BankAccountActionInvalidException {
        bankAccount.open();
        bankAccount.deposit(20);
        bankAccount.close();
        bankAccount.withdraw(5);
    }
    @Test(expected = BankAccountActionInvalidException.class)
    public void bankAccountIsClosedBeforeItIsOpened() throws BankAccountActionInvalidException {
        bankAccount.getBalance();
    }

    @Test
    public void canAdjustBalanceConcurrently() throws BankAccountActionInvalidException, InterruptedException {
        bankAccount.open();
        bankAccount.deposit(1000);
        for (int i = 0; i < 10; i++) {
            adjustBalanceConcurrently();
            Assert.assertEquals(bankAccount.getBalance(),(1000));
        }
    }

    private void adjustBalanceConcurrently() throws InterruptedException {
        Random random = new Random();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                try {
                    bankAccount.deposit(5);
                    Thread.sleep(random.nextInt(10));
                    bankAccount.withdraw(5);
                } catch (BankAccountActionInvalidException e) {
                    fail("Exception should not be thrown: " + e.getMessage());
                } catch (InterruptedException ignored) {
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

}