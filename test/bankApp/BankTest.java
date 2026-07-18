package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    int firstUser;
    Bank bank;

    @BeforeEach
    public void setUp(){
        bank = new Bank("Jiggy's Bank");
        firstUser = bank.registerCustomer("firstName", "lastName", "0123");
    }

    @Test
    public void registerCustomer() {
        assertEquals(100100, firstUser);
        int secondUser = bank.registerCustomer("secondName", "lastName", "0220");
        assertEquals(100101, secondUser);
    }
    @Test
    public void findAccountNumber() {
        int secondUser = bank.registerCustomer("secondName", "lastName", "0220");
        Account foundAccount = bank.findAccount(secondUser);

        assertEquals(100101, foundAccount.getNumber());
    }

    @Test
    public void findAccountNumber_AccountNotPresent () {
        int secondUser = bank.registerCustomer("secondName", "lastName", "0220");
        assertThrows(IllegalArgumentException.class, () -> bank.findAccount(100106));
    }

    @Test
    public void findAccountNumber_IRemoveIt () {
        int secondUser = bank.registerCustomer("secondName", "lastName", "0220");
        bank.removeAccount(100101, "0220");

        assertThrows(IllegalArgumentException.class, () -> bank.findAccount(100101));
    }
    @Test
    public void iDeposit1kIntoBankAccount () {
        bank.findAccount(firstUser);
        bank.deposit(firstUser, new BigDecimal(1000));

        assertEquals(new BigDecimal(1000), bank.checkBalance(firstUser, "0123"));
    }
    @Test
    public void iDeposit1k_withdrawWithWrongPin_ThrowsException (){
        bank.findAccount(firstUser);
        bank.deposit(firstUser, new BigDecimal(1000));

        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance(firstUser, "1234"));
    }

    @Test
    public void iDeposit2kIntoBankAccount_withdraw1k (){
        bank.findAccount(firstUser);
        bank.deposit(firstUser, new BigDecimal(2000));
        assertEquals(new BigDecimal(2000), bank.checkBalance(firstUser, "0123"));

        bank.withdraw(firstUser, new BigDecimal(1000), "0123");

        assertEquals(new BigDecimal(1000), bank.checkBalance(firstUser, "0123"));
    }

    @Test
    public void iDeposit2kIntoBankAccount_iTransfer1k (){
        bank.findAccount(firstUser);
        bank.deposit(firstUser, new BigDecimal(2000));
        assertEquals(new BigDecimal(2000), bank.checkBalance(firstUser, "0123"));

        int secondUser = bank.registerCustomer("secondName", "lastName", "0220");
        bank.transfer(firstUser, secondUser, new BigDecimal(1000), "0123");

        assertEquals(new BigDecimal(1000), bank.checkBalance(firstUser, "0123"));
        assertEquals(new BigDecimal(1000), bank.checkBalance(secondUser, "0220"));
    }
}
