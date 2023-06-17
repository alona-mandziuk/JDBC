package hw1.task3;

import hw1.RegisterDriver;

import java.sql.*;

class JoinsDBbyJDBCQueries {

    static {
        RegisterDriver.registerDriver();
    }

    private static final String URL = System.getenv("URL");
    private static final String LOGIN = System.getenv("LOGIN");
    private static final String PASSWORD = System.getenv("PASSWORD");

    /**
     * Method helps to get contact numbers and addresses of all workers.
     */

    static void getAllPhoneAndAdress() {
        System.out.println("Contact numbers and addresses of all workers: ");
        System.out.println("--------------------");
        String contacts = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.city, Another_Info.adress from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(contacts)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int pers_ID = resultSet.getInt("pers_ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String city = resultSet.getString("city");
                String adress = resultSet.getString("adress");

                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + city + ", " +
                        adress + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method helps to get info about birthdate of all unmarried workers.
     */

    static void getBirthdateAllUnmarried() {
        System.out.println("Info about birth date of all unmarried workers: ");
        System.out.println("--------------------");
        String dateofBirthOfUnmarried = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.birthdate from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id " +
                "where Another_info.marital_status = '0'";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(dateofBirthOfUnmarried)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int pers_ID = resultSet.getInt("pers_ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                Date birthdate = resultSet.getDate("birthdate");
                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + birthdate + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * .
     * Method helps to get info about all managers of the company: birthdate and contact phone number.
     */

    static void getAllManagersBirthdateAndPhone() {
        System.out.println("Info about all managers of the company: ");
        System.out.println("--------------------");
        String managerBirthday = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.birthdate from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id " +
                "join Salary on Personnel.pers_ID = Salary.id where Salary.position = 'manager'";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(managerBirthday)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int pers_ID = resultSet.getInt("pers_ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                Date birthdate = resultSet.getDate("birthdate");
                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + birthdate + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
