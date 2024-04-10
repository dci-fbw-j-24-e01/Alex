import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        System.out.println(isPalyndrome(scanner.nextLine()));
    }

    private static boolean isPalyndrome(String source) {
        source = source.replaceAll(" ", "").toLowerCase();
        StringBuilder reverse = new StringBuilder(source).reverse();
        return source.contentEquals(reverse);
    }
}
