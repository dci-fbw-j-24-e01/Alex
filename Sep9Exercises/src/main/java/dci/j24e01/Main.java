package dci.j24e01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Person> people;
    Connection connection;

    public static void main(String[] args) {
        Main main = new Main();
        int task = main.chooseTask();

        main.init();
        switch(task) {
            case 1: main.task1(); break;
            case 2: main.task2(); break;
            case 3: main.task3(); break;
            case 4: main.task4(); break;
            case 5: main.task5(); break;
            case 6: main.task6(); break;
            case 7: main.task7(); break;
            case 8: main.task8(); break;
            case 9: main.task9(); break;
            case 10: main.task10(); break;
        }
    }

    private void init() {
        people = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/whatever_you_like",
                    "root",
                    "ABcd1234!!"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int chooseTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input task number 1-10:");
        int task = scanner.nextInt();
        if (task < 1 || task > 10) {
            return chooseTask();
        }
        return task;
    }

    private void task1() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                            "SELECT * FROM people WHERE age BETWEEN 30 AND 35;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task2() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM people WHERE age BETWEEN 30 AND 35 OR city = 'Miami';");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task3() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM people WHERE name LIKE('A%');");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task4() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM people WHERE name LIKE('%A%') AND age > 17;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task5() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM people WHERE city LIKE('_____');");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task6() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM (SELECT * FROM people ORDER BY name DESC LIMIT 3) sub ORDER BY name ASC;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        null
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task7() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT COUNT(1) FROM people WHERE city = 'New York';");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getLong(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void task8() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT *, IF(age > 17, 'Adult', 'Child') AS ageDescription FROM people;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        resultSet.getString("ageDescription")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task9() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                            SELECT *,
                            \tIF(age > 17,\s
                            \t\tIF(age > 65, 'Senior', 'Adult')
                                    , 'Child') AS ageDescription
                            FROM people;""");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getLong("age"),
                        resultSet.getString("ageDescription")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        people.forEach(System.out::println);
    }

    private void task10() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                            SELECT city
                            FROM people
                            WHERE city IS NOT NULL
                            GROUP BY city
                            HAVING COUNT(1) > 1;""");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet.getString("city"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}