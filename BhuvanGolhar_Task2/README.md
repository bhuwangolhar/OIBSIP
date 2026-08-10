# Task 2: Number Guessing Game

A console-based Java application built as part of the **Oasis Infobyte Java Development Internship (OIBSIP)**. The application generates a secret random number within a chosen range, evaluates user guesses, provides dynamic feedback ("Too High" / "Too Low"), and tracks multi-round scores.

---

## 📌 Features

- **Difficulty Levels:**
  - **Easy:** Range 1–50, Max 10 attempts
  - **Medium:** Range 1–100, Max 7 attempts
  - **Hard:** Range 1–200, Max 5 attempts
- **Real-Time Feedback:** Displays "Too High!", "Too Low!", or "Correct!" after each guess.
- **Attempt Tracking:** Shows remaining attempts after every input.
- **Multi-Round Support:** Allows players to play multiple rounds in a single session.
- **Game Summary Report:** Displays a structured table at the end showing round numbers, difficulty levels, target numbers, attempts taken, and final outcome (Won/Lost).
- **Input Validation:** Handles non-integer inputs gracefully without crashing.

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8 or higher)
- **Input Handling:** `java.util.Scanner`
- **Logic:** `java.util.Random`, `java.util.ArrayList`, Control Structures

---

## 📁 Project Structure

```text
OIBSIP/
└── BhuvanGolhar_Task2/
    ├── src/
    │   └── NumberGuessingGame.java
    └── README.md
```

---

## 🚀 How to Run

### Option 1: Using Terminal / Command Line

1. Open your terminal and navigate to the `src` folder:

```bash
cd OIBSIP/BhuvanGolhar_Task2/src
```

2. Compile the Java file:

```bash
javac NumberGuessingGame.java
```

3. Run the application:

```bash
java NumberGuessingGame
```

### Option 2: Using an Online Java Compiler

1. Open [OnlineGDB Java Compiler](https://www.onlinegdb.com/online_java_compiler).
2. Copy the contents of `src/NumberGuessingGame.java`.
3. Paste the code into the online editor and click Run.

---

## 📋 Sample Output

```text
==================================================
       WELCOME TO THE NUMBER GUESSING GAME        
==================================================

--------------------------------------------------
ROUND 1
--------------------------------------------------
Select Difficulty Level:
1. Easy   (Range: 1 to 50,  Max Attempts: 10)
2. Medium (Range: 1 to 100, Max Attempts: 7)
3. Hard   (Range: 1 to 200, Max Attempts: 5)
Enter choice (1-3): 1

I've picked a number between 1 and 50. You have 10 attempts!

[Attempt 1 of 10] Enter your guess: 25
📉 Too High!
Attempts remaining: 9

[Attempt 2 of 10] Enter your guess: 12
🎉 Correct! You guessed the number 12 in 2 attempts!

==================================================
                   GAME SUMMARY                   
==================================================
Round    Difficulty   Target   Attempts     Status  
--------------------------------------------------
1        Easy         12       2            WON     
--------------------------------------------------
Total Rounds Played : 1
Total Rounds Won    : 1
==================================================
```

---

## 👤 Author

- **Name:** Bhuvan Golhar
- **Domain:** Java Development Intern
- **Organization:** Oasis Infobyte