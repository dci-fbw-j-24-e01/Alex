import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size:");
        int size = scanner.nextInt();
        System.out.println("Enter an amount:");
        int times = scanner.nextInt();

        while (times-- > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(i + 1);
                }
                System.out.println();
            }
        }
    }
}
