import java.util.ArrayList;
import java.util.Random;


public class Account {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with initial balance: " + String.format("%.2f", initialBalance));
    }

    //AccountNuber Generation

    public static String accontNumbergenerartion() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        String deffauitNum = "8008";
        buffer.append(deffauitNum);
        for (int i = 0; i < 8; i++) {
            buffer.append(random.nextInt(9) + 1);
        }
        return buffer.toString();
    }

    //Deposite
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: ₹" + String.format("%.2f", amount) +
                    " | Balance: " + String.format("%.2f", balance));
            System.out.println("Deposited of ammount ₹"+amount+" is successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: ₹" + String.format("%.2f", amount) +
                    " | Balance: " + String.format("%.2f", balance));
            System.out.println("Withdrawal of ammount ₹"+amount+" is successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    //Balance
    public double getBalance() {
        return balance;
    }

    //History
    public void showTransactions() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}
