import java.util.*;

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        accounts = Bank.loadAccounts(); // Load saved accounts on startup

        while (true) {
            System.out.println("\n=== SAGE BANKING SYSTEM ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you for using our service!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Set a 4-digit PIN for your account: ");
        String pin = scanner.nextLine();

        String accountNumber = "ACC" + (int)(Math.random() * 100000);
        Account account = new Account(accountNumber, name, initialDeposit, pin);

        accounts.put(accountNumber, account);
        Bank.saveAccount(account);

        System.out.println("✅ Account created successfully!");
        System.out.println("Your Account Number is: " + accountNumber);
    }

    private static void login() {
        System.out.print("Enter your account number: ");
        String accNum = scanner.nextLine();

        Account account = accounts.get(accNum);
        if (account == null) {
            System.out.println("❌ Account not found.");
            return;
        }

        System.out.println("🔓 Logged in as: " + account.getName());

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    Bank.logTransaction(new Transaction(accNum, "Deposit: +" + depositAmount));
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        Bank.logTransaction(new Transaction(accNum, "Withdraw: -" + withdrawAmount));
                        System.out.println("✅ Withdrawal successful!");
                    } else {
                        System.out.println("❌ You have not enough money.");
                    }
                    break;

                case 3: // Check Balance
                    System.out.print("Enter your 4-digit PIN: ");
                    String inputPin = scanner.next();

                    if (account.verifyPin(inputPin)) {
                        System.out.println("💰 Current Balance: " + account.getBalance());
                    } else {
                        System.out.println("❌ Incorrect PIN. Access denied.");
                    }
                    break;

                case 4:
                    System.out.println("\n🧾 Transaction History:");
                    List<String> transactions = Bank.loadTransactions(accNum);
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (String t : transactions) {
                            System.out.println("- " + t);
                        }
                    }
                    break;

                case 5:
                    System.out.println("👋 Logging out...");
                    return;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}