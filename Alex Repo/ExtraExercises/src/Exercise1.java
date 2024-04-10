import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String source) {
        source = source.toLowerCase();
        for (int i = 0; i < source.length() / 2; i++) {
            if (source.charAt(i) != source.charAt(source.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
