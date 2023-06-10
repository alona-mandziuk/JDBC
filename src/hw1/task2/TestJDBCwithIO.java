package hw1.task2;

import hw1.RegisterDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

class TestJDBCwithIO {
    private static final String URL = "jdbc:mysql://localhost:3306/zoomarket";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws IOException {
        String dataQueries = new String(Files.readAllBytes
                (Paths.get("src/hw1/task2/QueriesToZoomarket.txt")));
        String[] queries = dataQueries.split("\\n");

        RegisterDriver.registerDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            for (int i = 0; i < queries.length; i++) {
                statement.execute(queries[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
