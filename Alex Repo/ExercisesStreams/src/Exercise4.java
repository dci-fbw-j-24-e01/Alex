import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        List<String> strings = List.of("Alive", "Alien", "Boolean", "Character");

        long count = strings.stream()
                .filter(word -> word.startsWith("A"))
                .count();

        System.out.println(count);
    }
}
