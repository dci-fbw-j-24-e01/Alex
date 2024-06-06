import java.net.URL;

public record User(
        int id,
        String name,
        String userName,
        String email,
        Address address,
        String phone,
        URL website,
        Company company) {
}
