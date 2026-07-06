package bankApp;

public class Account {

    private int balance;
    private String name;
    private String pin;
    private int newAccountNumber;

    public Account(String fullName, String password, int newAccountNumber) {
        this.name = fullName;
        this.pin = password;
        this.newAccountNumber = newAccountNumber;
    }

    public int getBalance(String pin){
        validatePin(pin);
        return balance;
    }

    public void deposit(int amount) {
       if (amount>0) balance = balance + amount;
        }

    public void withdraw(int amount, String userPin) {
        validatePin(userPin);

        if (amount < balance) balance = balance - amount;
    }
//
//    public void transfer(Account secondAccount, int sent, String UserPin) {
//
//        validatePin(UserPin);
//
//        if (sent > balance) {
//            throw new IllegalArgumentException("Insufficient balance");
//        }
//
//        balance = balance - sent;
//        secondAccount.deposit(sent);
    private void validatePin(String userPin) {
        if (!this.pin.equals(userPin)) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
    }
    public int getNumber() {
        return newAccountNumber;

    }
}

