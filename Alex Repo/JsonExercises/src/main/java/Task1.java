import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) throws IOException {
        URL customerURL = Task1.class.getResource("/users.json");
        Path customerPath = Path.of(customerURL.getPath().replace("%20", " "));
        String content = Files.readString(customerPath);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(content);
        List<User> users = new ArrayList<>();

        for (int i = 0; i < rootNode.size(); i++) {

            JsonNode userNode = rootNode.get(i);
            int id = userNode.get("id").asInt();
            String name = userNode.get("name").asText();
            String userName = userNode.get("username").asText();
            String email = userNode.get("email").asText();

            JsonNode addressNode = userNode.get("address");
            String street = addressNode.get("street").asText();
            String suite = addressNode.get("suite").asText();
            String city = addressNode.get("city").asText();
            String zipCode = addressNode.get("zipcode").asText();

            JsonNode geoLocationNode = addressNode.get("geo");
            double lat = geoLocationNode.get("lat").asDouble();
            double lng = geoLocationNode.get("lng").asDouble();

            GeoLocation geoLocation = new GeoLocation(lat, lng);
            Address address = new Address(street, suite, city, zipCode, geoLocation);

            String phone = userNode.get("phone").asText();

            URL website = new URL("https://" + userNode.get("website").asText());

            JsonNode companyNode = userNode.get("company");
            String companyName = companyNode.get("name").asText();
            String catchPhrase = companyNode.get("catchPhrase").asText();
            String bs = companyNode.get("bs").asText();
            Company company = new Company(companyName, catchPhrase, bs);

            User user = new User(id, name, userName, email, address, phone, website, company);

            users.add(user);
        }

        System.out.println(users.size());
    }
}

