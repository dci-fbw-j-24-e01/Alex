import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(2, 2, 4, 4, 5, 6, 1);

        ints = ints.stream()
                .distinct()
                .toList();

        System.out.println(ints);
    }
}
