package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    Account myAccount;

    @BeforeEach
    public void setUp(){
        myAccount = new Account();
    }

    @Test
    public void deposit1000IntoAnEmptyAccountAndBalanceIs1000() {
        myAccount.deposit(1000);
        myAccount.deposit(500);

        assertEquals(1500, myAccount.getBalance());
    }
    @Test
    public void depositNegative500IntoAnEmptyAccountAndBalanceIs0() {
        myAccount.deposit(-500);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void withdraw50FromAnEmptyAccountAndBalanceIs0() {
        myAccount.withdraw(50);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void deposit1000FromMyAccountAndWithdraw400BalanceIs600() {
        myAccount.deposit(1000);
        myAccount.withdraw(400);
        assertEquals(600, myAccount.getBalance());

    }

    @Test
    public void iDeposit2000AndTransfer1300_BalanceIs700 () {
        myAccount.deposit(2000);
        Account secondAccount = new Account();
        myAccount.transfer(secondAccount, 1300);

        assertEquals(700, myAccount.getBalance());
        assertEquals(1300, secondAccount.getBalance());
    }

    @Test
    public void iDeposit1000AndTransfer1500_returnsException () {
        myAccount.deposit(1000);
        Account secondAccount = new Account();

        assertThrows(IllegalArgumentException.class, () -> myAccount.transfer(secondAccount, 1500));
    }

    }

