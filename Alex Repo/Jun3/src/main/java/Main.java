import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        URL customerURL = Main.class.getResource("/customers.json");
        Path customerPath = Path.of(customerURL.getPath().replace("%20", " "));
        String content = Files.readString(customerPath);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(content);

        for (int i = 0; i < rootNode.size(); i++) {
            JsonNode customerNode = rootNode.get(i);
            String firstName = customerNode.get("First Name").asText();
            String lastName = customerNode.get("Last Name").asText();
            String email = customerNode.get("Email").asText();

            System.out.println("Name:    " + firstName + " " + lastName);
            System.out.println("E-mail:  " + email);
            System.out.println("-------------------------------------------------");

        }

    }
}
