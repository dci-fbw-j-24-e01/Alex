import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the USD amount:");
        float usd = scanner.nextFloat();
        float ratio = 0.9230f;
        float eur = usd * ratio;
        System.out.printf("%.2f USD is %.2fEUR", usd, eur);
    }
}
