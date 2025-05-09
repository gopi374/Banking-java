public class Transaction {
    private String accountNumber;
    private String description;

    public Transaction(String accountNumber, String description) {
        this.accountNumber = accountNumber;
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return accountNumber + "," + description;
    }
}