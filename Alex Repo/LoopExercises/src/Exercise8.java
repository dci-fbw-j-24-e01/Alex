import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int result = 0;
        int n = scanner.nextInt();
        System.out.println("Enter + to compute the sum or * to compute the product:");
        char operation = scanner.next().charAt(0);
        if (operation != '+' && operation != '*') {
            System.out.println("Wrong input. Restart the application.");
            System.exit(666);
        }
        int i = 0;
        if (operation == '*') {
            result++;
        }

        while (i++ < n) {
            if (operation == '+') {
                result += i;
            } else {
                result *= i;
            }
            System.out.print(i);
            if (i < n) {
                System.out.print(" " + operation + " ");
            }

        }
        System.out.println(" = " + result);
    }
}
