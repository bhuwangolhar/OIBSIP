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