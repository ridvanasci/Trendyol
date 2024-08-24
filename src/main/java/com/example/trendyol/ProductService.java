package com.example.trendyol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {

    private static final String DB_URL = "jdbc:h2:mem:test";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    public void saveProduct(Product product) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (name, description, price) VALUES (?, ?, ?)");
            stmt.setString(1, product.getUrunAdi());
            stmt.setString(2, product.getUrunAciklamasi());
            stmt.setDouble(3, product.getUrunFiyati());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception
        }
    }

    public Product getProductById(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setUrunID(rs.getDouble("id"));
                product.setUrunAdi(rs.getString("name"));
                product.setUrunAciklamasi(rs.getString("description"));
                product.setUrunFiyati(rs.getFloat("price"));
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // Handle the exception
        }
        return null;
    }

    public void updateProduct(Product product) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?");
            stmt.setString(1, product.getUrunAdi());
            stmt.setString(2, product.getUrunAciklamasi());
            stmt.setDouble(3, product.getUrunFiyati());
            stmt.setDouble(4, product.getUrunID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception
        }
    }

    public void deleteProduct(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception
        }
    }
}