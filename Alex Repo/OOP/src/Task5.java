import java.util.HashSet;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write something:");

        String input = scanner.nextLine();
        System.out.println("The number of charecters: " + input.length());

        HashSet<Character> chars = new HashSet<>();
        for (Character c : input.toCharArray()) {
            chars.add(c);
        }

        System.out.println("The number of unique characters: " + chars.size());
    }
}
