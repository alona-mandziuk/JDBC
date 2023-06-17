package hw1.task2;

import hw1.RegisterDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

class TestJDBCwithIO {

    public static void main(String[] args) {

        String dataQueries = null;
        try {
            dataQueries = new String(Files.readAllBytes
                    (Paths.get("src/hw1/task2/QueriesToZoomarket.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] queries = dataQueries.split("\\n");

        executeQueriesFromFile(queries);

    }


    private static final String URL = System.getenv("URL");
    private static final String LOGIN = System.getenv("LOGIN");
    private static final String PASSWORD = System.getenv("PASSWORD");

    static {
        RegisterDriver.registerDriver();
    }

    static void executeQueriesFromFile(String[] strings) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            for (int i = 0; i < strings.length; i++) {
                statement.execute(strings[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
