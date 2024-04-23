import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private int lives = 6;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public String start() {
        String word = Words.getRandomWord();
        char[] chars = word.toCharArray();
        ArrayList<Boolean> guessed = new ArrayList<>(word.length());

        for (char aChar : chars) {
            if (aChar == ' ') {
                guessed.add(true);
            } else {
                guessed.add(false);
            }
        }

        boolean won = false;
        while (lives > 0) {

            printWord(word, guessed);
            char c;

            while (true) {
                System.out.println("Enter the character:");
                String input = scanner.nextLine();
                if (input != null && !input.isEmpty()) {
                    c = input.toUpperCase().charAt(0);
                    break;
                }
            }

            boolean success = false;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c && guessed.get(i)) {
                    System.out.println("You have already entered this character");
                } else if (chars[i] == c) {
                    success = true;
                    guessed.set(i, true);
                }
            }

            if (!success) {
                lives--;
                System.out.println("You missed! " + lives + " lives left.");
            }

            if (!guessed.contains(false)) {
                won = true;
                break;
            }
        }

        if (won) {
            System.out.println(word);
            return "Congratulations! You won! You have " + lives + " live" + (lives > 1 ? "s" : "") + " left";
        }

        return "Better luck next time.";
    }

    private static void printWord(String word, ArrayList<Boolean> guessed) {
        System.out.println("code phrase is:");
        for (int i = 0; i < word.length(); i++) {
            if (guessed.get(i)) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print('_');
            }
        }
        System.out.println();
    }
}
