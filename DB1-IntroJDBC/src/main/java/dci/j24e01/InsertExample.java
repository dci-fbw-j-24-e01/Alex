package dci.j24e01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "ABcd1234!!"
        );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO city (id, name, countryCode, district, population) " +
                        "VALUES (NULL, ?, ?, ?, ?)"
        );

        statement.setString(1, "City of Helder");
        statement.setString(2, "PRT");
        statement.setString(3, "Helder's district");
        statement.setLong(4, 1);

        if (statement.executeUpdate() > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
