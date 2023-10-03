package play;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import impl.WordManager;
import util.InputUtil;

public class GamerStarter {
    public static void launchGame() throws FileNotFoundException {
        WordManager wordManager = new WordManager();
        Scanner scanner = new Scanner(System.in);

        wordManager.loadWordPairsFromFile("play/WordsWithPairs.txt");

        int score = 0;

        while (true) {
            int choice = showMenu(scanner);

            if (choice == 1) {
                int pointsEarned = PlayGame.playGame(wordManager, "Azerbaijani");
                score += pointsEarned;
            } else if (choice == 2) {
                int pointsEarned = PlayGame.playGame(wordManager, "French");
                score += pointsEarned; 
            } else if (choice == 3) {
                saveScoreToFile(score, "score.txt");
                System.out.println("Thank you for playing. Your score: " + score);
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static int showMenu(Scanner scanner) {
        System.out.println("Menu:");
        System.out.println("1. Play Azerbaijani Game");
        System.out.println("2. Play French Game");
        System.out.println("3. Exit");

        int choice = InputUtil.inputRequiredInt("Enter your choice: ");
        return choice;
    }

    public static void saveScoreToFile(int score, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

