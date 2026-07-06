package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String bankName;

    private final List<Account> accounts = new ArrayList<>();
    private int accountCounter = 100100;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public int registerCustomer(String nameOne, String nameTwo, String password) {
        String fullName = nameOne + " " + nameTwo;
        int newAccountNumber = accountCounter++;
        Account newAccount = new Account(fullName, password, newAccountNumber);
        accounts.add(newAccount);
        return newAccountNumber;
    }

    public Account findAccount(int accountNumber) {
        for (int count = 0; count < accounts.size(); count++) {
            if (accounts.get(count).getNumber() == accountNumber) return accounts.get(count);
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public void removeAccount(int AccountNumber, String pin) {
        Account account = findAccount(AccountNumber);
        account.getBalance(pin);
        accounts.remove(account);
    }

    public void deposit(int accountNumber, int amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public int checkBalance(int accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int senderAccountNumber, int receiverAccountNumber, int amount, String pin) {
        Account senderAccount = findAccount(senderAccountNumber);
        Account receieverAccount = findAccount(receiverAccountNumber);
        senderAccount.withdraw(amount, pin);
        receieverAccount.deposit(amount);
    }
}
