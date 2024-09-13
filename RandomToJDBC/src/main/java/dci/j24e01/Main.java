package dci.j24e01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/random_numbers",
                "root",
                "ABcd1234!!")) {

            DBQuery dbQuery = new DBQuery(connection);

            int valuesWritten = dbQuery.writeNumbers();
            if (valuesWritten > 0) {
                System.out.println(dbQuery.writeNumbers() + " numbers generated.");
            }

            System.out.println("The most frequent number is " + dbQuery.getMostFrequentNumber() + ".");

            System.out.println(dbQuery.clearDB() + " numbers are removed from the database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}