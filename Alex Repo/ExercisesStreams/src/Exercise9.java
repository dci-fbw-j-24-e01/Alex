import java.util.List;

public class Exercise9 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double average = ints.stream()
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();

        System.out.println(average);
    }
}
