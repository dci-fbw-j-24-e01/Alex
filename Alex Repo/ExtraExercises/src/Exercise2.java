import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        System.out.println(reverse(input));
    }

    public static String reverse(String source) {
        StringBuilder sb = new StringBuilder(source);
        sb.reverse();
        return sb.toString();
    }
}
