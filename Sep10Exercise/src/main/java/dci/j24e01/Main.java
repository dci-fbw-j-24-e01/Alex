package dci.j24e01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "ABcd1234!!")) {

            CityDAO cityDao = new CityDAOMysqlImpl(connection);

            cityDao.deleteCity(4083L);
// System.out.println(cityDao.findCity(3445L));
//
// City city = new City(null, "Helder's city", "PRT", "Porto", 1);
// City newCity = cityDao.insertCity(city);
            List<City> cities = cityDao.findCities();



        } catch (SQLException e) {
            System.out.println("Something went wrong... ");
        }
    }
}