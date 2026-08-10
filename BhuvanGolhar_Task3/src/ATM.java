import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private final Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("==================================================");
        System.out.println("            WELCOME TO THE ATM SYSTEM             ");
        System.out.println("==================================================");

        int attempts = 0;
        Account currentAccount = null;

        // Authentication loop (Max 3 attempts)
        while (attempts < 3) {
            System.out.print("\nEnter User ID: ");
            String userId = scanner.next();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            currentAccount = bank.authenticate(userId, pin);

            if (currentAccount != null) {
                System.out.println("\n✅ Authentication Successful! Welcome, " + currentAccount.getHolderName());
                runMenu(currentAccount);
                return;
            } else {
                attempts++;
                System.out.printf("❌ Invalid User ID or PIN. Attempts left: %d\n", (3 - attempts));
            }
        }

        System.out.println("\n⛔ Access Denied! Maximum attempts reached. Exiting system.");
    }

    private void runMenu(Account account) {
        boolean sessionActive = true;

        while (sessionActive) {
            System.out.println("\n==================================================");
            System.out.println("                    MAIN MENU                     ");
            System.out.println("==================================================");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option (1-5): ");

            int choice = getValidInteger();

            switch (choice) {
                case 1:
                    account.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = getValidDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = getValidDouble();
                    account.deposit(depositAmt);
                    break;
                case 4:
                    System.out.print("Enter Recipient Account ID: ");
                    String recipientId = scanner.next();
                    Account recipient = bank.getAccount(recipientId);
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmt = getValidDouble();
                    account.transfer(recipient, transferAmt);
                    break;
                case 5:
                    System.out.println("\nThank you for using the ATM. Goodbye!");
                    sessionActive = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please select between 1 and 5.");
                    break;
            }
        }
    }

    private int getValidInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid amount: ₹");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}