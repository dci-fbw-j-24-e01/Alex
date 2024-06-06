import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static ObjectMapper mapper;
    public static void main(String[] args) throws IOException, URISyntaxException {
        mapper = new ObjectMapper();
        JsonNode rootContent = getContent("https://swapi.dev/api/films/");
        Set<String> charsUrls = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (JsonNode charactersNode: rootContent.get("results").get(i).get("characters")) {
                charsUrls.add(charactersNode.asText());
            }
        }
        Set<String> characters = new HashSet<>();
        for (String charLink: charsUrls) {
            JsonNode characterNode = getContent(charLink);
            StringBuilder sb = new StringBuilder(characterNode.get("name").asText());
            JsonNode speciesNode = characterNode.get("species").get(0);
            if (speciesNode == null) {
                sb.append("'s species are UNKNOWN");
            } else {
                sb.append(" is a ")
                        .append(getContent(speciesNode.asText()).get("name").asText());
            }
            characters.add(sb.toString());
        }
        characters.forEach(System.out::println);
    }

    private static JsonNode getContent(String uri) throws URISyntaxException, IOException {
        URL url = (new URI(uri)).toURL();
        InputStream content = (InputStream) url.getContent();
        return mapper.readTree(content);
    }
}