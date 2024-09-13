package dci.j24e01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOMysqlImpl implements CountryDAO {

    private final Connection connection;
    private final CityDAOMysqlImpl cityDAOMysqlImpl;

    public CountryDAOMysqlImpl(Connection connection, CityDAOMysqlImpl cityDAOMysqlImpl) {
        this.connection = connection;
        this.cityDAOMysqlImpl = cityDAOMysqlImpl;
    }

    @Override
    public Country findCountry(String countryCode) {
        String query = """
                SELECT *
                FROM country
                WHERE code = ?
                """;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, countryCode);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            return createCountryObject(resultSet).getFirst();

        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Country> findCountries() {
        String query = "SELECT * FROM country";

        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(query);

            return createCountryObject(resultSet);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean updateCountry(Country country) {
        String query = """
                UPDATE country
                SET name = ?, continent = ?, region = ?, SurfaceArea = ?, IndepYear = ?, Population = ?,
                    LifeExpectancy = ?, GNP = ?, GNPOld = ?, LocalName = ?, GovernmentForm = ?, HeadOfState = ?,
                    Capital = ?, Code2 = ?
                WHERE code = ?
                """;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, country.name());
            statement.setString(2, country.continent());
            statement.setString(3, country.region());
            statement.setDouble(4, country.surfaceArea());
            statement.setShort(5, country.indepYear());
            statement.setLong(6, country.population());
            statement.setFloat(7, country.lifeExpectancy());
            statement.setDouble(8, country.gnp());
            statement.setDouble(9, country.oldGnp());
            statement.setString(10, country.localName());
            statement.setString(11, country.governmentForm());
            statement.setString(12, country.headOfState());
            statement.setString(13, country.capital().name());
            statement.setString(14, country.code2());
            statement.setString(15, country.code());

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean insertCountry(Country country) {
        String query =  """
                INSERT INTO country
                (name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold,\s
                        localname, governmentform, headofstate, capital, code2, code)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
               \s""";
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {


            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCountry(String countryCode) {
        String sql = "DELETE FROM country WHERE code = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, countryCode);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    private List<Country> createCountryObject(ResultSet resultSet) throws SQLException {
        List<Country> countries = new ArrayList<>();
        while (resultSet.next()) {
            countries.add(new Country(
                    resultSet.getString("code"),
                    resultSet.getString("name"),
                    resultSet.getString("continent"),
                    resultSet.getString("region"),
                    resultSet.getDouble("surfaceArea"),
                    resultSet.getShort("indepYear"),
                    resultSet.getLong("population"),
                    resultSet.getFloat("lifeExpectancy"),
                    resultSet.getDouble("gnp"),
                    resultSet.getDouble("gnpOld"),
                    resultSet.getString("localName"),
                    resultSet.getString("governmentForm"),
                    resultSet.getString("headOfState"),
                    cityDAOMysqlImpl.findCity(resultSet.getLong("capital")),
                    resultSet.getString("code2")
            ));
        }
        return countries;
    }

    private void setStatement(PreparedStatement statement, Country country) throws SQLException {
        statement.setString(1, country.name());
        statement.setString(2, country.continent());
        statement.setString(3, country.region());
        statement.setDouble(4, country.surfaceArea());
        statement.setShort(5, country.indepYear());
        statement.setLong(6, country.population());
        statement.setFloat(7, country.lifeExpectancy());
        statement.setDouble(8, country.gnp());
        statement.setDouble(9, country.oldGnp());
        statement.setString(10, country.localName());
        statement.setString(11, country.governmentForm());
        statement.setString(12, country.headOfState());
        statement.setString(13, country.capital().name());
        statement.setString(14, country.code2());
        statement.setString(15, country.code());
    }
}
