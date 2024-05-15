import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = ints.stream()
                .filter(x -> (x % 2 == 0))
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
