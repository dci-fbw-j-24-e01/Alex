import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a = scanner.nextInt();
        System.out.println("Enter a number:");
        int b = scanner.nextInt();
        if (b == 0) {
            System.out.println("Sorry, cannot divide by zero.");
        } else {
            System.out.println(a / b);
        }
    }
}
