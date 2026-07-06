package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account("name", "1234", 100100);
    }

    @Test
    public void deposit1000IntoAnEmptyAccountAndBalanceIs1000() {
        myAccount.deposit(1000);
        myAccount.deposit(500);

        assertEquals(1500, myAccount.getBalance("1234"));
    }

    @Test
    public void depositNegative500IntoAnEmptyAccountAndBalanceIs0() {
        myAccount.deposit(-500);

        assertEquals(0, myAccount.getBalance("1234"));
    }

    @Test
    public void withdraw50FromAnEmptyAccountAndBalanceIs0() {
        myAccount.withdraw(50, "1234");

        assertEquals(0, myAccount.getBalance("1234"));
    }

    @Test
    public void deposit1000FromMyAccountAndWithdraw400BalanceIs600() {
        myAccount.deposit(1000);
        myAccount.withdraw(400, "1234");
        assertEquals(600, myAccount.getBalance("1234"));
    }

    @Test
    public void deposit2kWithdraw1kWithIncorrectPin() {
        myAccount.deposit(2000);
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(1000, "2020"));
        assertEquals(2000, myAccount.getBalance("1234"));
    }
}

