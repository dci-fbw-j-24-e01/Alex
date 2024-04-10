import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For how many nights would you like to stay?");
        int days = scanner.nextInt();

        System.out.println("Which type of room would you like?");
        System.out.println("Base price per room:");
        System.out.println("1. Normal room: 90€");
        System.out.println("2. Deluxe room: 120€");
        System.out.println("3. Deluxe suites: 150€");
        System.out.println("Enter 1, 2 or 3 to choose the type of room:");

        int type = scanner.nextInt();

        System.out.println("Do you have an extra guest? (10€ / night) y/n");

        String guest = scanner.next().toLowerCase();

        int totalCost = 0;

        int guests = 1;

        if (guest.equals("y") || guest.equals("yes")) {
            guests++;
            totalCost += 10;
        }
        if (type == 1) {
            totalCost += 90;
        } else if (type == 2) {
            totalCost += 120;
        }
        else {
            totalCost += 150;
        }

        totalCost *= days;

        if (days > 14) {
            totalCost -= totalCost / 5;
        }
        else if (days > 9) {
            totalCost -= totalCost * 15 / 100;
        }
        else if (days > 4) {
            totalCost -= totalCost / 20;
        }

        System.out.println("Do you want to include breakfast? y/n");
        String breakfast = scanner.next().toLowerCase();

        if (breakfast.equals("y") || breakfast.equals("yes")) {
            totalCost += 10 * days * guests;
        }

        System.out.println("The total cost is " + totalCost + "€.");
    }
}
