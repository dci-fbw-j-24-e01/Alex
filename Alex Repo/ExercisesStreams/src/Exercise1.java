import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<String> strings = List.of("hello", "world");

        strings = strings.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(strings);
    }
}
