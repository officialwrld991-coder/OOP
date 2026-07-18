package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

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
        myAccount.deposit(new BigDecimal("1000"));
        myAccount.deposit(new BigDecimal("500"));

        assertEquals(new BigDecimal("1500"), myAccount.getBalance("1234"));
    }

    @Test
    public void depositNegative500IntoAnEmptyAccountAndBalanceIs0() {
        myAccount.deposit(new BigDecimal("-500"));

        assertEquals(BigDecimal.ZERO, myAccount.getBalance("1234"));
    }

    @Test
    public void withdraw50FromAnEmptyAccountAndBalanceIs0() {
        myAccount.withdraw(new BigDecimal("50"), "1234");

        assertEquals(BigDecimal.ZERO, myAccount.getBalance("1234"));
    }

    @Test
    public void deposit1000FromMyAccountAndWithdraw400BalanceIs600() {
        myAccount.deposit(new BigDecimal("1000"));
        myAccount.withdraw(new BigDecimal("400"), "1234");

        assertEquals(new BigDecimal("600"), myAccount.getBalance("1234"));
    }

    @Test
    public void deposit2kWithdraw1kWithIncorrectPin() {
        myAccount.deposit(new BigDecimal("2000"));
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(new BigDecimal("1000"), "2020"));

        assertEquals(new BigDecimal("2000"), myAccount.getBalance("1234"));
    }
}