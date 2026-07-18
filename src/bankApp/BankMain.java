package bankApp;

import javax.swing.*;
import java.util.Scanner;
import java.math.BigDecimal;

public class BankMain {

    private static final Bank myBank = new Bank("JIGGY'S BANK");
    private static Scanner inputCollector = new Scanner(System.in);

    public static void main(String[] args) {
        goToBankMenu();
    }

    public static void goToBankMenu() {
        String prompt = """
                WELCOME TO JIGGY'S BANK!!!
                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                6. Exit
                """;
        char userInput = input(prompt).charAt(0);
        switch (userInput) {
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> checkBalance();
            case '6' -> exit();
            default -> {
                print("Invalid input. Please try again.");
                goToBankMenu();
            }
        }
    }


    public static void createAccount() {
        try {
            String firstName = input("Enter first name: ");
            String lastName = input("Enter last name: ");
            String pin = input("Enter pin: ");
            int accountNumber = myBank.registerCustomer(firstName, lastName, pin);
            print("Account created successfully!!! \nYour account number is: " + accountNumber);
            goToBankMenu();
        }  catch (Exception e) {
            print("Unsuccessful Registration" + e.getMessage());
            goToBankMenu();
        }
    }


    public  static void deposit() {
      try {
          int accountNumber = Integer.parseInt(input("Enter account number: "));
          String amount = input("Enter amount: ");
          BigDecimal depositedAmount = new BigDecimal(amount);
          myBank.deposit(accountNumber, depositedAmount);
          print("Deposit successful!!!");
          goToBankMenu();
      }  catch (Exception e) {
          print("Deposit not Successful" + e.getMessage());
          goToBankMenu();
      }
    }


    public  static void withdraw() {
        try {
            int accountNumber = Integer.parseInt(input("Enter account number: "));
            String amount = input("Enter amount: ");
            BigDecimal withdrawAmount = new BigDecimal(amount);
            String pin = input("Enter pin: ");
            myBank.withdraw(accountNumber, withdrawAmount, pin);
            BigDecimal newBalance = myBank.checkBalance(accountNumber, pin);
            print("Withdraw successful!!!");
            print("Your balance is: " + newBalance);
            goToBankMenu();
        }    catch (IllegalArgumentException e) {
            print("Insufficient Balance" + e.getMessage());
            goToBankMenu();
        }   catch (Exception e)  {
            print("Invalid Pin" + e.getMessage());
            goToBankMenu();
        }

    }


    public  static void transfer() {
        try {
            int accountNumber = Integer.parseInt(input("Enter account number: "));
            int receiverAccountNumber = Integer.parseInt(input("Enter receiver account number: "));
            String amount = input("Enter amount: ");
            BigDecimal transferredAmount = new BigDecimal(amount);
            String pin = input("Enter pin: ");
            myBank.transfer(accountNumber, receiverAccountNumber, transferredAmount, pin);
            BigDecimal newBalance = myBank.checkBalance(accountNumber, pin);
            print("Transfer successful!!!");
            print("Your balance is: " + newBalance);
            goToBankMenu();
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("Account")) {
                print("Invalid Account Number: " + errorMessage);
            } else if (errorMessage.contains("Balance")) {
                print("Insufficient Balance: " + errorMessage);
            } else {
                print("Error: " + errorMessage);
            }
            goToBankMenu();
        } catch (Exception e) {
            print("Incorrect Pin" + e.getMessage());
            goToBankMenu();
        }
    }


    public  static void checkBalance() {
        try {
            int accountNumber = Integer.parseInt(input("Enter account number: "));
            String pin = input("Enter pin: ");
            BigDecimal balance = myBank.checkBalance(accountNumber, pin);
            print("Your balance is: " + balance);
            goToBankMenu();
        } catch (Exception e) {
            print("Invalid Pin" + e.getMessage());
            goToBankMenu();
        }
    }

    public  static void exit() {
        print("Thank you for using our Bank!");
        System.exit(0);
    }

    private static void print(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

}



