import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {

    private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String TRANSACTIONS_FILE = "transactions.txt";

    // Save all accounts to file
    public static void saveAccounts(Map<String, Account> accounts) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_FILE))) {
            out.writeObject(accounts);
            System.out.println("💾 Accounts saved successfully.");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving accounts.");
        }
    }

    // Load accounts from file
    @SuppressWarnings("unchecked")
    public static Map<String, Account> loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ACCOUNTS_FILE))) {
            return (Map<String, Account>) in.readObject();
        } catch (Exception e) {
            System.out.println("⚠️ No saved accounts found.");
            return new HashMap<>();
        }
    }

    // Save a transaction
    public static void logTransaction(String accountNumber, String transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            writer.write(accountNumber + ": " + transaction);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("⚠️ Failed to log transaction.");
        }
    }

    // Load and display transactions for an account
    public static void loadAndDisplayTransactions(String accNum) {
        System.out.println("\n🧾 Transaction History:");
        try (Scanner scanner = new Scanner(new File(TRANSACTIONS_FILE))) {
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(accNum)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No transactions found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Transaction file not found.");
        }
    }
}