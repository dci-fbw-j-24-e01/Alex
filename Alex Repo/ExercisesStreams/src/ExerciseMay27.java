import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ExerciseMay27 {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        URL sampleUrl = ExerciseMay27.class.getResource("sample.txt");
        assert sampleUrl != null;
        URI sampleUri = sampleUrl.toURI();
        File sampleFile = new File(sampleUri);
        Scanner input = new Scanner(sampleFile);

        List<String> paragraphs = new ArrayList<>();

        while (input.hasNext()) {
            String line = input.nextLine().trim();
            if (!line.isEmpty()) {
                paragraphs.add(line);
            }
        }
        input.close();

        List<List<String>> fileContent = new ArrayList<>();
        fileContent.add(paragraphs);

        int counter = fileContent.getFirst().size();
        System.out.println("There is " + counter + " paragraph" + (counter == 1 ? "" : "s") + " in the file.");

        List<String> sentences = new ArrayList<>();

        for (String paragraph : fileContent.getFirst()) {
            sentences.addAll(Arrays.asList(paragraph.split("\\.")));
        }

        fileContent.add(sentences);

        counter = fileContent.get(1).size();
        System.out.println("There is " + counter + " sentence" + (counter == 1 ? "" : "s") + " in the file.");

        List<String> words = new ArrayList<>();

        for (String sentence: sentences) {
            words.addAll(Arrays.asList(sentence.split(" ")));
        }
        for (int i = words.size() - 1; i >= 0; i--) {
            if (words.get(i).isEmpty()) {
                words.remove(i);
            }
        }

        fileContent.add(words);

        counter = fileContent.get(2).size();
        System.out.println("There is " + counter + " word" + (counter == 1 ? "" : "s") + " in the file.");

        // Bonus

        fileContent.get(2).replaceAll(String::toLowerCase);

        Map<String, Integer> frequency = fileContent.get(2).stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        int max = 0;
        String word = "";

        for (Map.Entry<String, Integer> pair : frequency.entrySet()) {
            if (pair.getValue() > max) {
                word = pair.getKey();
                max = pair.getValue();
            }
        }

        System.out.println("The word " + word + " shows up " + max + " time" + (max == 1 ? "." : "s."));
    }

}
