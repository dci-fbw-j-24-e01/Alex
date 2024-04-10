import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int available = 1000;
        System.out.println("How much money would you like to withdraw?");
        System.out.println(available + " was left in the account");
        int withdrawal = scanner.nextInt();
        if (withdrawal > available) {
            System.out.println("Not enough money on your account. Gotta work harder...");
        }
        else {
            System.out.println("Transaction confirmed. Take your cash.");
        }
    }
}
