import java.util.Comparator;
import java.util.List;

public class Exercise6 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int max = ints.stream()
                .max(Comparator.comparingInt(x -> x))
                .get();

        System.out.println(max);
    }
}
