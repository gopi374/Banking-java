import java.io.*;
import java.util.*;

public class Bank {
    private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String TRANSACTIONS_FILE = "transactions.txt";

    public static Map<String, Account> loadAccounts() {
        Map<String, Account> accounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String accountNumber = parts[0];
                    String name = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    String pin = parts[3];
                    accounts.put(accountNumber, new Account(accountNumber, name, balance, pin));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading accounts: " + e.getMessage());
        }
        return accounts;
    }

    public static void saveAccount(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(account.getAccountNumber() + "," + account.getName() + "," + account.getBalance() + "," + account.getPin());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving account: " + e.getMessage());
        }
    }

    public static void logTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            writer.write(transaction.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error logging transaction: " + e.getMessage());
        }
    }

    public static List<String> loadTransactions(String accountNumber) {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2); // Split into account number and description
                if (parts.length == 2 && parts[0].equals(accountNumber)) {
                    transactions.add(parts[1]); // Add the transaction description
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }
}