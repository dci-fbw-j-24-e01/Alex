import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        URL sampleUrl = Task4.class.getResource("sample.txt");
        assert sampleUrl != null;
        URI sampleUri = sampleUrl.toURI();
        File sampleFile = new File(sampleUri);
        Scanner input = new Scanner(sampleFile);

        StringBuilder sb = new StringBuilder();

        while (input.hasNext()) {
            String line = input.nextLine().trim();
            if (!line.isEmpty()) {
                sb.append("<p>")
                        .append(line)
                        .append("<\\p>\n");
            }
        }
        input.close();

        Path path = Path.of("FilesExercises/resources/sample.html");
        try {
            Files.writeString(path, sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
