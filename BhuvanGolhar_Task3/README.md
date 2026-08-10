# Task 3: ATM Interface

A console-based Java application simulating an Automated Teller Machine (ATM) system built as part of the **Oasis Infobyte Java Development Internship (OIBSIP)**. The project follows Object-Oriented Programming (OOP) principles and multi-class architecture to handle user authentication, deposit, withdrawal, fund transfer, and transaction logging.

---

## 📌 Features

- **User Authentication:** Requires User ID and PIN to log in (locks access after 3 failed attempts).
- **Transaction History:** Tracks all transactions (Deposits, Withdrawals, Transfers) with timestamps, transaction types, amounts, and remaining balances.
- **Deposit:** Allows users to deposit funds with real-time balance updates.
- **Withdrawal:** Enables withdrawing funds with strict balance validation to prevent overdrafts ("Insufficient Funds").
- **Transfer:** Facilitates direct account-to-account transfers using recipient User IDs with account existence and balance checks.
- **Robust Input Validation:** Prevents negative/zero inputs and non-numeric scanner errors.

---

## 🛠️ Tech Stack & Concepts

- **Language:** Java (JDK 8 or higher)
- **Object-Oriented Design:** Modular design utilizing 5 distinct Java classes (`ATM`, `Account`, `Transaction`, `Bank`, `Main`) demonstrating Encapsulation, Abstraction, and Data Hiding.
- **Data Structures:** `ArrayList` for dynamic transaction histories, `HashMap` for fast account lookup by ID.
- **Date & Time API:** `java.time.LocalDateTime` for exact transaction timestamping.

---

## 📁 Project Structure

```text
OIBSIP/
└── BhuvanGolhar_Task3/
    ├── src/
    │   ├── Transaction.java
    │   ├── Account.java
    │   ├── Bank.java
    │   ├── ATM.java
    │   └── Main.java
    └── README.md
```

---

## 🔑 Test Credentials

| User ID | PIN    | Account Holder | Initial Balance |
| ------- | ------ | --------------- | ---------------- |
| `1001`  | `1234` | Bhuvan Golhar    | ₹5,000.00        |
| `1002`  | `5678` | John Doe     | ₹3,000.00        |

---

## 🚀 How to Run

### Option 1: Using Terminal / Command Line

1. Open your terminal and navigate to the `src` folder:

```bash
cd OIBSIP/BhuvanGolhar_Task3/src
```

2. Compile all Java source files:

```bash
javac *.java
```

3. Run the application:

```bash
java Main
```

### Option 2: Using an Online Java Compiler

1. Open [OnlineGDB Java Compiler](https://www.onlinegdb.com/online_java_compiler).
2. Create separate tabs/files for `Transaction.java`, `Account.java`, `Bank.java`, `ATM.java`, and `Main.java` (or combine them into a single file with `Main` as the public class).
3. Click **Run**.

---

## 📋 Sample Output

```text
==================================================
            WELCOME TO THE ATM SYSTEM             
==================================================

Enter User ID: 1001
Enter PIN: 1234

✅ Authentication Successful! Welcome, Bhuvan Golhar

==================================================
                    MAIN MENU                     
==================================================
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option (1-5): 3
Enter amount to deposit: ₹2000
✅ Successfully deposited ₹2000.00. New Balance: ₹7000.00

==================================================
                    MAIN MENU                     
==================================================
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option (1-5): 4
Enter Recipient Account ID: 1002
Enter amount to transfer: ₹1000
✅ Successfully withdrew ₹1000.00. Remaining Balance: ₹6000.00
✅ Transferred ₹1000.00 to John Doe (1002)

==================================================
                    MAIN MENU                     
==================================================
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Choose an option (1-5): 1

--------------------------------------------------
TRANSACTION HISTORY FOR ACCOUNT: 1001
--------------------------------------------------
[2026-08-10 17:03:15] INITIAL    | Amount: ₹5000.00  | Balance: ₹5000.00
[2026-08-10 17:05:13] DEPOSIT    | Amount: ₹2000.00  | Balance: ₹7000.00
[2026-08-10 17:06:07] WITHDRAW   | Amount: ₹1000.00  | Balance: ₹6000.00
--------------------------------------------------
```

---

## 👤 Author

- **Name:** Bhuvan Golhar
- **Domain:** Java Development Intern
- **Organization:** Oasis Infobyte