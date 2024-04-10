import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        String input = scanner.nextLine();

        //   A
        /*for (String word : input.split(" ")) {
            System.out.println(word);
        }*/

        //   B
        /*for (String word : input.split("\\.")) {
            System.out.println(word.trim() + ".");
        }*/

        //   C
        String[] words = input.split(" ");
        for (String word : words) {
            if (word.matches("\\d+")) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
        for (String word : words) {
            if (word.matches("\\D+")) {
                System.out.print(word + " ");
            }
        }
    }
}
