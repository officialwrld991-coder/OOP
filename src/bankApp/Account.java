package bankApp;

public class Account {

    private int balance;
    private int secondBalance;
    String pin;

    public int getBalance(){

        return balance;
    }

    public void deposit(int amount) {
       if (amount>0) balance = balance + amount;
        }

    public void withdraw(int amount) {

        if (amount < balance) balance = balance - amount;
    }

    public void transfer(Account secondAccount, int sent) {

        if (sent > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance = balance - sent;
        secondAccount.deposit(sent);
    }



    }

