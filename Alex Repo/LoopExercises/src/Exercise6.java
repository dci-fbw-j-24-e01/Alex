import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int sum = 0;
        int n = scanner.nextInt();
        int i = 0;

        while (i++ < n) {
            sum += i;
            System.out.print(i);
            if (i < n) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + sum);
    }
}
