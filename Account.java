import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private String pin; // Add PIN field
    private List<String> transactions;

    public Account(String accountNumber, String name, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.pin = pin; // Initialize PIN
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public boolean verifyPin(String inputPin) {
        return this.pin.equals(inputPin); // Verify PIN
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposit: +" + amount + ", Balance: " + balance;
            transactions.add(transaction);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Insufficient funds or invalid amount
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return accountNumber + "," + name + "," + balance;
    }

    public static Account fromString(String line) {
        String[] parts = line.split(",");
        return new Account(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
    }
}