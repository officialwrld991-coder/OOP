package bankApp;

public class Account {

    private int balance;
    private int secondBalance;
    String pin = "0000";

    public Account(String userPin){
        this.pin = userPin;
    }

    public int getBalance(){

        return balance;
    }

    public void deposit(int amount) {
       if (amount>0) balance = balance + amount;
        }

    public void withdraw(int amount, String userPin) {
        validatePin(userPin);

        if (amount < balance) balance = balance - amount;
    }

    public void transfer(Account secondAccount, int sent, String UserPin) {

        validatePin(UserPin);

        if (sent > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance = balance - sent;
        secondAccount.deposit(sent);
    }
    private void validatePin(String userPin) {
        if (!this.pin.equals(userPin)) {
            throw new IllegalArgumentException("Incorrect PIN. Access Denied.");
        }
    }



    }

