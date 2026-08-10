import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Hardcoded dummy accounts for testing
        addAccount(new Account("1001", "1234", "Bhuvan Golhar", 5000.00));
        addAccount(new Account("1002", "5678", "John Doe", 3000.00));
    }

    public void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    public Account authenticate(String userId, String pin) {
        Account acc = getAccount(userId);
        if (acc != null && acc.validatePin(pin)) {
            return acc;
        }
        return null;
    }
}