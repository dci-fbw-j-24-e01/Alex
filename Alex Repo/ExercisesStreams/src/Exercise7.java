import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise7 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.shuffle(ints);

        int result = ints.stream()
                .sorted()
                .skip(1)
                .findFirst()
                .get();

        System.out.println(result);
    }
}
