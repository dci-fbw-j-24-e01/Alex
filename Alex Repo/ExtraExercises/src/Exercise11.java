import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the min value:");
        int min = scanner.nextInt();
        System.out.println("Enter the max value:");
        int max = scanner.nextInt();
        if (max <= min) {
            System.out.println("Wrong input. Restart the application and enter correct values.");
        } else {
            int result = (int) (Math.random() * (max - min + 1)) + min;
            System.out.println("The random number is " + result);
        }

    }
}
