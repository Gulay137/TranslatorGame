package util;
import enums.Selections;
import java.util.Scanner;

class MenuUtil {
    public static int showMenu() {
    	System.out.println("_________________________________");
        System.out.println("**** Word Counterpart Game ****");
        System.out.println("1. " + Selections.PLAY_AZERBAIJANI);
        System.out.println("2. " + Selections.PLAY_FRENCH);
        System.out.println("3. " + Selections.EXIT);
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        return choice;
    }
}