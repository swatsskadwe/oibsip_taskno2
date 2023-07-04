import java.util.Random;
import javax.swing.*;

public class RandomNumber {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 10;
        int score = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

        boolean gameWon = false;
        int attempts = 0;

        while (!gameWon && attempts < maxAttempts) {
            String guessString = JOptionPane.showInputDialog(null, "Guess the number between "
                    + rangeStart + " and " + rangeEnd + ":");
            
            if (guessString == null) {
                // User clicked cancel, exit the game
                System.exit(0);
            }
            
            int guess = Integer.parseInt(guessString);
            attempts++;

            if (guess == randomNumber) {
                gameWon = true;
                score += (maxAttempts - attempts + 1) * 10;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber
                        + " in " + attempts + " attempts.\nYour score: " + score);
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Try again! The number is higher.");
            } else {
                JOptionPane.showMessageDialog(null, "Try again! The number is lower.");
            }
        }

        if (!gameWon) {
            JOptionPane.showMessageDialog(null, "Game over! You have used all your attempts.\nThe number was: "
                    + randomNumber + "\nYour final score: " + score);
        }
    }
}
