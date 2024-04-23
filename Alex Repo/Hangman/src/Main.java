import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press Enter to play or 'exit' to close the application:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("See you next time!");
                break;
            }
            String result = new Game(scanner).start();
            System.out.println(result);
        }
    }
}
