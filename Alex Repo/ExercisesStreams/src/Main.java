import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("9788845292613", "Lord of the Rings", "J. R. R. Tolkien", Category.FICTION));
        books.add(new Book("9788070217740", "La metamorfosi (Proměna)", "F. Kafka", Category.MYSTERY));
        books.add(new Book("3551551677", "Harry Potter und der Stein der Weisen", "J. K. Rowling", Category.NOVEL));
        books.add(new Book("9780582060104", "Animal Farm", "G. Orwell", Category.NOVEL));

        List<Character> chars = books.stream()
                .map(Book::getTITLE)
                .map(o1 -> o1.charAt(0))
                .distinct()
                .sorted(Character::compareTo)
                .toList();

        System.out.println(chars);
    }
}
