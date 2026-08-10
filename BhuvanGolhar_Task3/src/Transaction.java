import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final double remainingBalance;
    private final String timestamp;

    public Transaction(String type, double amount, double remainingBalance) {
        this.type = type;
        this.amount = amount;
        this.remainingBalance = remainingBalance;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {
        return String.format("[%s] %-10s | Amount: ₹%-8.2f | Balance: ₹%.2f", 
                timestamp, type, amount, remainingBalance);
    }
}