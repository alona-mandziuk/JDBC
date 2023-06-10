package hw1.task1;

import hw1.RegisterDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class TestJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/zoomarket";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        RegisterDriver.registerDriver();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("insert  into assortment (product_name, price) " +
                    "values ('Bouncies', 3)");
            statement.addBatch("insert into assortment (product_name, price)" +
                    "values ('Fish Stripes', 2.5)");
            statement.addBatch("insert into assortment (product_name, price)" +
                    "values ('Treats with Lamb flavour', 4.5)");

            statement.executeBatch();
            statement.executeUpdate("update assortment set price = price + 0.6 where product_name = 'Bouncies'");
            statement.execute("delete from assortment where id > 10");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
