import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String userId;
    private String pin;
    private final String holderName;
    private double balance;
    private final List<Transaction> transactionHistory;

    public Account(String userId, String pin, String holderName, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("INITIAL", initialBalance);
    }

    public String getUserId() { return userId; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("DEPOSIT", amount);
            System.out.printf("✅ Successfully deposited ₹%.2f. New Balance: ₹%.2f\n", amount, balance);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
            return false;
        }
        if (amount > balance) {
            System.out.println("❌ Insufficient Funds! Current Balance: ₹" + String.format("%.2f", balance));
            return false;
        }
        balance -= amount;
        addTransaction("WITHDRAW", amount);
        System.out.printf("✅ Successfully withdrew ₹%.2f. Remaining Balance: ₹%.2f\n", amount, balance);
        return true;
    }

    public boolean transfer(Account recipient, double amount) {
        if (recipient == null) {
            System.out.println("❌ Recipient account not found!");
            return false;
        }
        if (recipient.getUserId().equals(this.userId)) {
            System.out.println("❌ Cannot transfer money to your own account!");
            return false;
        }
        if (this.withdraw(amount)) {
            recipient.balance += amount;
            recipient.addTransaction("RECEIVED", amount);
            System.out.printf("✅ Transferred ₹%.2f to %s (%s)\n", amount, recipient.getHolderName(), recipient.getUserId());
            return true;
        }
        return false;
    }

    private void addTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount, balance));
    }

    public void printTransactionHistory() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("TRANSACTION HISTORY FOR ACCOUNT: " + userId);
        System.out.println("--------------------------------------------------");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
        System.out.println("--------------------------------------------------");
    }
}