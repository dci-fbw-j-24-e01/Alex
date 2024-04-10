import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side a of the Triangle:");
        int a = scanner.nextInt();
        System.out.println("Enter side b of the Triangle:");
        int b = scanner.nextInt();

        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        System.out.println("The Hypotenuse of the Triangle is " + c);
    }
}
