import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");

        String input = scanner.nextLine().toUpperCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                sb.append(' ');
                continue;
            }
            if (c < 65 || c > 90) {
                System.out.println("Unknown character. Restart an application. " + i + " " + (int) c);
                System.exit(666);
            }
            if (c < 68) {
                sb.append((char) (c + 23));
            } else {
                sb.append((char) (c - 3));
            }
        }
        System.out.println(sb);
    }
}
