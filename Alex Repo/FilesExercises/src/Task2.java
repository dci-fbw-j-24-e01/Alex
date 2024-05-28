import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    public static void main(String[] args) {
        Path path = Path.of(System.getProperty("user.home") + "/Рабочий стол");
        try {
            Files.list(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
