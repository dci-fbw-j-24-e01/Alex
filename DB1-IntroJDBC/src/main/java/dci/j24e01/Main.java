package dci.j24e01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "ABcd1234!!"
        );

        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT id, name AS city, population FROM city LIMIT 10");
//
//        while(resultSet.next()) {
//            String name = resultSet.getString("city");
//            System.out.println(name);
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a letter:");
//        String letter = "%" + scanner.next() + "%";
//
//        resultSet = statement.executeQuery("SELECT name FROM city WHERE name LIKE " + letter);
//
//        while(resultSet.next()) {
//            String name = resultSet.getString("name");
//            System.out.println(name);
//        }

        PreparedStatement preparedStatement = connection.prepareStatement(
//                "SELECT * FROM city WHERE name LIKE ?"
                "SELECT * FROM city LIMIT 5"
        );
//        preparedStatement.setString(1, letter);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<City> cities = new ArrayList<>();
        while (resultSet.next()) {
            cities.add(new City(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("countryCode"),
                    resultSet.getString("district"),
                    resultSet.getLong("population")
            ));
        }

        System.out.println(cities);
    }

}
