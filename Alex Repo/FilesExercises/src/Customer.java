import java.net.URL;
import java.time.LocalDate;

public record Customer(String index, String id, String firstname, String LastName, String company, String city, String country,
                       String phone1, String phone2, String email, LocalDate subscriptionDate, URL website) {
}
