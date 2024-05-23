import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            ints.add(i);
        }

        long start = System.currentTimeMillis();

        ints.stream()
                .filter(x -> x % 3 == 0)
                .map(Math::sqrt)
                .limit(10)
                .forEach(System.out::println);

        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms");
    }
}
