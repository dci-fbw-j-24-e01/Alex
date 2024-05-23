import java.util.List;
import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            ints.add(i);
        }

        ints.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> (int)Math.pow(x, 2))
                .forEach(System.out::println);
    }
}