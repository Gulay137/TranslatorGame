package play;

import impl.WordManager;
import java.util.Scanner;
import model.WordPair;

public class PlayGame {
    public static int playGame(WordManager wordManager, String language) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; 

        while (true) {
            System.out.print("Enter a word in " + language + ": ");
            String word = scanner.nextLine().toLowerCase().trim();

            WordPair counterpartPair = wordManager.findCounterpart(word, language);

            if (counterpartPair != null) {
                String counterpart = counterpartPair.getCounterpart();
                System.out.println("The counterpart in another language is: " + counterpart);
               
                score += 1; 
            } else {
                System.out.println("Word not found in the storage.");
            }

            System.out.print("Play again? Type yes to play again (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase().trim();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

      
        System.out.println("Your final score: " + score);
		return score;
    }

	
	}




