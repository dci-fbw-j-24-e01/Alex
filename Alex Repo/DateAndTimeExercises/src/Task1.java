import java.time.LocalDate;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Birth year:");
        int year = scanner.nextInt();
        if (year < 100 && year > 23) {
            year += 1900;
        } else if (year < 23) {
            year += 2000;
        }
        System.out.println("Did you have a birthday this year? y / n");
        String had = scanner.next().toLowerCase();
        if (had.equals("n") || had.equals("no")) {
            year++;
        }
        System.out.println("You are " + (LocalDate.now().getYear() - year) + " years old.");
    }
}
