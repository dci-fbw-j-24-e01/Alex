import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int sum = 0;
        int n = scanner.nextInt();
        int i = 0;

        while (i++ < n) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i > 3) {
                    System.out.print(" + ");
                }
                sum += i;
                System.out.print(i);
            }
        }
        System.out.println(" = " + sum);
    }
}
