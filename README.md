🏦 Java Console Banking System -- Terminal based
A simple terminal-based banking system built using Core Java , allowing users to create an account, log in with a PIN, and perform basic banking operations like deposit, withdrawal, balance inquiry, and transaction history viewing.

✅ Features
Create Account
1. Set up a new account with a unique 4-digit PIN.
Login with PIN
1.Secure access using a 4-digit PIN.
Deposit Money
1.Deposit funds into your account.
Withdraw Money
1.Withdraw money (with sufficient balance check).
Check Balance
1.View current account balance.
Transaction History
1.See a list of all past transactions (deposits and withdrawals).
Sent payments
1. In this you can transfer the funds.

🛠️ Technologies Used
Java (Core)
Console Input/Output : Using Scanner and standard output
Data Storage : In-memory using HashMap (non-persistent)
OOP Principles : Encapsulation, abstraction, and modular design.


📁 Project Structure
BankingApp/
│
├── src/
│   ├── Main.java              // Application entry point
│   ├── Bank.java              // Handles user authentication and banking menu
│   ├── Account.java           // Represents a bank account
│   └── Transaction.java       // Stores individual transaction details
│
└── README.md
▶️ How to Run the Application
Prerequisites:
1.JDK installed (Java Development Kit)
2.Terminal or Command Line access.

Steps:
Clone the repository:
git clone https://github.com/gopi374/Banking-java.git 

Navigate to the project directory:
cd java-banking

Compile Java files:
javac src/*.java

Run the application:
java src/Main

💡 Sample Usage (Terminal Interaction)
Welcome to Java Banking!

1. Create New Account
2. Login to Existing Account
Enter your choice: 1

Enter a 4-digit PIN: 1234
Account created successfully! Your initial balance is $0.00

Returning to main menu...

1. Create New Account
2. Login to Existing Account
Enter your choice: 2

Enter your PIN: 1234

Login successful!

Choose an option:
1. Deposit
2. Withdraw
3. Check Balance
4. View Transaction History
5. Logout
Enter your choice: 1

Enter amount to deposit: 500
$500.00 deposited successfully.

...and so on.
🔒 Note on Data Persistence
This project stores user data in memory only (using Java collections). All data will be lost when the program exits. To make this production-ready:

Implement file-based storage (e.g., save/load accounts to .txt or .ser files)
Or integrate a database like MySQL or SQLite for persistent data
🧪 Future Improvements
Add support for multiple accounts
Enable fund transfers between accounts
Add logout timeout
Implement input validation robustly
Save transaction logs to file
Build a GUI version using JavaFX/Swing
📚 License
This project is licensed under the MIT License – see the LICENSE file for details.

🤝 Contributing
Contributions are welcome! Feel free to fork this project, make improvements, and open a pull request.

📩 Contact
For questions or suggestions, feel free to reach out:

📧 Email: gopibanjara87@gmail.com
💻 GitHub: https://github.com/gopi374

Thank you for using our Java Console Banking System ! Perfect for beginners learning Java OOP concepts and terminal interaction. 💻💸
