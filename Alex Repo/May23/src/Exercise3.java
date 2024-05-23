import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            ints.add(i);
        }

        int a = ints.stream()
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(a);

        int b = ints.stream()
                .reduce((x, y) -> x * y)
                .orElse(0);
        System.out.println(b);
    }
}
