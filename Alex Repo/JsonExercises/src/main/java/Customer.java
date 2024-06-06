import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        @JsonProperty("Index") int index,
        @JsonProperty("Customer id") String customerId,
        @JsonProperty("First name") String name,
        @JsonProperty("Last name") String lastName,
        @JsonProperty("Company") String company,
        @JsonProperty("City") String city,
        @JsonProperty("Country") String country,
        @JsonProperty("Phone 1") String phone1,
        @JsonProperty("Phone 2") String phone2,
        @JsonProperty("Email") String email,
        @JsonProperty("Subscription Date") String subscriptionDate,
        @JsonProperty("Website") String website
        ) {
}
