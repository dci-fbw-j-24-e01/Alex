import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        String input = scanner.nextLine();

        String[] array = input.split(" ");
        for (String s: array) {
            System.out.println(s);
        }
    }
}
