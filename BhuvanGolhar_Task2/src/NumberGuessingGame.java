import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Class to keep track of round statistics for summary report
    static class RoundResult {
        int roundNumber;
        String difficulty;
        int targetNumber;
        int attemptsTaken;
        boolean won;

        public RoundResult(int roundNumber, String difficulty, int targetNumber, int attemptsTaken, boolean won) {
            this.roundNumber = roundNumber;
            this.difficulty = difficulty;
            this.targetNumber = targetNumber;
            this.attemptsTaken = attemptsTaken;
            this.won = won;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<RoundResult> gameHistory = new ArrayList<>();

        int roundCounter = 1;
        boolean playAgain = true;

        System.out.println("==================================================");
        System.out.println("       WELCOME TO THE NUMBER GUESSING GAME        ");
        System.out.println("==================================================");

        while (playAgain) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("ROUND " + roundCounter);
            System.out.println("--------------------------------------------------");

            // Difficulty Level Selection
            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy   (Range: 1 to 50,  Max Attempts: 10)");
            System.out.println("2. Medium (Range: 1 to 100, Max Attempts: 7)");
            System.out.println("3. Hard   (Range: 1 to 200, Max Attempts: 5)");
            System.out.print("Enter choice (1-3): ");

            int choice = getValidInteger(scanner);
            int maxRange = 100;
            int maxAttempts = 7;
            String difficultyName = "Medium";

            switch (choice) {
                case 1:
                    maxRange = 50;
                    maxAttempts = 10;
                    difficultyName = "Easy";
                    break;
                case 2:
                    maxRange = 100;
                    maxAttempts = 7;
                    difficultyName = "Medium";
                    break;
                case 3:
                    maxRange = 200;
                    maxAttempts = 5;
                    difficultyName = "Hard";
                    break;
                default:
                    System.out.println("Invalid selection! Defaulting to Medium difficulty.");
                    break;
            }

            int targetNumber = random.nextInt(maxRange) + 1;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.printf("\nI've picked a number between 1 and %d. You have %d attempts!\n", maxRange, maxAttempts);

            // Round loop
            while (attemptsUsed < maxAttempts) {
                attemptsUsed++;
                int remainingAttempts = maxAttempts - attemptsUsed;

                System.out.printf("\n[Attempt %d of %d] Enter your guess: ", attemptsUsed, maxAttempts);
                int userGuess = getValidInteger(scanner);

                if (userGuess == targetNumber) {
                    System.out.printf("🎉 Correct! You guessed the number %d in %d attempts!\n", targetNumber, attemptsUsed);
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("📉 Too High!");
                } else {
                    System.out.println("📈 Too Low!");
                }

                if (remainingAttempts > 0) {
                    System.out.printf("Attempts remaining: %d\n", remainingAttempts);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ You Lost! You've used all your attempts.");
                System.out.printf("The secret number was: %d\n", targetNumber);
            }

            // Save round stats
            gameHistory.add(new RoundResult(roundCounter, difficultyName, targetNumber, attemptsUsed, guessedCorrectly));

            // Ask to play again
            System.out.print("\nDo you want to play another round? (Y/N): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.startsWith("y")) {
                playAgain = false;
            } else {
                roundCounter++;
            }
        }

        // Final Game Summary
        displayGameSummary(gameHistory);

        System.out.println("\nThank you for playing! Goodbye!");
        scanner.close();
    }

    // Helper method for input validation
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Displays overall score summary across rounds
    private static void displayGameSummary(List<RoundResult> history) {
        System.out.println("\n==================================================");
        System.out.println("                   GAME SUMMARY                   ");
        System.out.println("==================================================");
        System.out.printf("%-8s %-12s %-8s %-12s %-8s\n", "Round", "Difficulty", "Target", "Attempts", "Status");
        System.out.println("--------------------------------------------------");

        int totalWins = 0;
        for (RoundResult res : history) {
            String status = res.won ? "WON" : "LOST";
            if (res.won) totalWins++;

            System.out.printf("%-8d %-12s %-8d %-12d %-8s\n",
                    res.roundNumber, res.difficulty, res.targetNumber, res.attemptsTaken, status);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total Rounds Played : %d\n", history.size());
        System.out.printf("Total Rounds Won    : %d\n", totalWins);
        System.out.println("==================================================");
    }
}