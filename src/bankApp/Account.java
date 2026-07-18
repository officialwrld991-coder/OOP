package bankApp;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private String name;
    private String pin;
    private int newAccountNumber;

    public Account(String fullName, String password, int newAccountNumber) {
        this.name = fullName;
        this.pin = password;
        this.newAccountNumber = newAccountNumber;
    }

    public BigDecimal getBalance(String pin){
        validatePin(pin);
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
    }

    public void withdraw(BigDecimal amount, String userPin) {

        if (amount.compareTo(balance) < 0) {
            balance = balance.subtract(amount);
        }
    }

    private void validatePin(String userPin) {
        if (!this.pin.equals(userPin)) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
    }

    public int getNumber() {
        return newAccountNumber;
    }
}