import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>(60000);
        int number = 2;
        while (primes.size() < 60000) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }

        System.out.println(--number);
        System.out.println(primes);
    }

    private static boolean isPrime(int number) {

        if (number % 2 == 0) {
            return number == 2;
        }

        for (int i = 3; i < number / 2; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}