import java.util.Scanner;

public class Excercise12 {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100 + 1);
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        for (int i = 0; i < 6; i++) {
            System.out.println("Enter the number:");
            int guess = scanner.nextInt();
            if (number > guess) {
                System.out.println("Your number is too small.");
            }
            else if (number < guess) {
                System.out.println("Your number is too large.");
            }
            else {
                win = true;
                break;
            }
        }
        System.out.println(win ? "Congratulations!" : "Better luck next time!");
    }
}
