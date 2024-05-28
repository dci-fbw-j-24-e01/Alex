import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = List.of("Lana", "Sunanda", "Desiree", "Vitalii", "Indaleci", "Oleg", "Alex");

        for (int i = 1; i <= list.size(); i++) {
            Path path = Path.of("FilesExercises/resources/String" + i + ".txt");
            try {
                Files.writeString(path, list.get(i - 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
