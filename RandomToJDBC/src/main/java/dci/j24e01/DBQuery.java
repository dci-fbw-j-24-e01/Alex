package dci.j24e01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBQuery {
    private final Connection connection;

    public DBQuery(Connection connection) {
        this.connection = connection;
    }

    public int writeNumbers() {
        Random random = new Random();

        String query = "INSERT INTO numbers (numbers) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < 10000; i++) {
                statement.setInt(1, random.nextInt(1, 1001));
                statement.addBatch();
            }
            int[] results = statement.executeBatch();

            int totalRowsAffected = 0;
            for (int count : results) {
                totalRowsAffected += count;
            }

            return totalRowsAffected;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public short getMostFrequentNumber() {
        String query = """
                SELECT numbers, COUNT(*) as frequency
                FROM numbers
                GROUP BY numbers
                ORDER BY frequency DESC
                LIMIT 1""";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getShort(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int clearDB() {
        String query = "DELETE FROM numbers";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
