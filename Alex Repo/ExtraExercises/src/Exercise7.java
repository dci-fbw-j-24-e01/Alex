import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        String input = scanner.nextLine();

        String[] array = input.split(" ");
        int max = 0;
        for (String s: array) {
            int size = s.length();
            if (size > max) {
                max = size;
            }
        }
        System.out.println("*".repeat(max + 4));
        for (String s: array) {
            System.out.print("* " + s);
            System.out.print(" ".repeat(max - s.length()));
            System.out.println(" *");
        }
        System.out.println("*".repeat(max + 4));

    }
}
