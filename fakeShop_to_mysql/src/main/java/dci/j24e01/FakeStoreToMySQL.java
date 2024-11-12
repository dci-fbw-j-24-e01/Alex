package dci.j24e01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.*;
import java.util.List;

class Product {
    public int id;
    public String title;
    public String description;
    public double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

public class FakeStoreToMySQL {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/fakestore_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "ABcd1234!!";

    private static final String API_URL = "https://fakestoreapi.com/products";

    public static void main(String[] args) {
        List<Product> products = fetchProductsFromAPI();

        if (products != null) {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                createTableIfNotExists(conn);
                saveProductsToDatabase(conn, products);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Product> fetchProductsFromAPI() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonData = response.body().string();

                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(jsonData, new TypeReference<List<Product>>() {});
            } else {
                System.err.println("Ошибка при запросе к API: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Метод для создания таблицы, если она не существует
    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                "id INT PRIMARY KEY, " +
                "title VARCHAR(255), " +
                "description TEXT, " +
                "price DOUBLE)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    // Метод для сохранения данных в базу данных
    private static void saveProductsToDatabase(Connection conn, List<Product> products) throws SQLException {
        String insertSQL = "INSERT INTO products (id, title, description, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            for (Product product : products) {
                pstmt.setInt(1, product.id);
                pstmt.setString(2, product.title);
                pstmt.setString(3, product.description);
                pstmt.setDouble(4, product.price);
                pstmt.executeUpdate();
            }
        }
    }
}
