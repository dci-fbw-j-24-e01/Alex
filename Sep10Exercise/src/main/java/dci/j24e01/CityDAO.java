package dci.j24e01;

import java.util.List;

public interface CityDAO {
    City findCity(Long id);

    List<City> findCities();

    boolean updateCity(City city);

    City insertCity(City city);

    boolean deleteCity(Long id);
}
