package dci.j24e01;

import java.util.List;

public interface CountryDAO {
    Country findCountry(String countryCode);

    List<Country> findCountries();

    boolean updateCountry(Country country);

    boolean insertCountry(Country country);

    boolean deleteCountry(String countryCode);
}
