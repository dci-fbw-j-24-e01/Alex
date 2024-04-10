import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size:");
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print(" ".repeat(size - i - 1));
            System.out.print("*".repeat(1 + i * 2));
            System.out.println();
        }
        System.out.print(" ".repeat(size - 1));
        System.out.print('I');
    }
}


