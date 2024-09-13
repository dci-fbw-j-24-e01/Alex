package dci.j24e01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAOMysqlImpl implements CityDAO {

    private final Connection connection;

    public CityDAOMysqlImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public City findCity(Long id) {
        String query = """
                SELECT *
                FROM city
                WHERE id = ?
                """;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            return new City(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("countryCode"),
                    resultSet.getString("district"),
                    resultSet.getInt("population")
            );
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<City> findCities() {
        String query = "SELECT * FROM city";

        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(query);

            List<City> cities = new ArrayList<>();

            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("countryCode"),
                        resultSet.getString("district"),
                        resultSet.getInt("population")
                ));
            }
            return cities;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean updateCity(City city) {
        String query = """
                UPDATE city
                SET name = ?, countryCode = ?, district = ?, population = ?
                WHERE id = ?
                """;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, city.name());
            statement.setString(2, city.countryCode());
            statement.setString(3, city.district());
            statement.setInt(4, city.population());
            statement.setLong(5, city.id());

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public City insertCity(City city) {
        String query =  """
                INSERT INTO city
                (id, name, countryCode, district, population)
                VALUES(NULL, ?, ?, ?, ?)
                """;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, city.name());
            preparedStatement.setString(2, city.countryCode());
            preparedStatement.setString(3, city.district());
            preparedStatement.setInt(4, city.population());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                ResultSet keysResultSet = preparedStatement.getGeneratedKeys();
                keysResultSet.next();

                Long insertId = keysResultSet.getLong(1);

                return new City(
                        insertId,
                        city.name(),
                        city.countryCode(),
                        city.district(),
                        city.population()
                );

            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteCity(Long id) {
        String sql = "DELETE FROM city WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }
}
