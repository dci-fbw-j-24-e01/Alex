import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<String> strings = List.of("Alive", "Alien", "Boolean", "Character");

        strings = strings.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .toList();

        System.out.println(strings);
    }
}
