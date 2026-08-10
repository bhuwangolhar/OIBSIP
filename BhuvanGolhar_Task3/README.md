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