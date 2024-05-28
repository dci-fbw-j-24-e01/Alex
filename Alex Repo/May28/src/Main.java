import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("May28/example.txt");
        String content = Files.readString(filePath);

        Files.writeString(Path.of(System.getProperty("user.home") + "/Рабочий стол/copy.txt"), content);
        System.out.println(content);
    }
}