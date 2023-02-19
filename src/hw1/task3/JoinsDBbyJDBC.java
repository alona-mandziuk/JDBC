package hw1.task3;

import java.sql.*;

class JoinsDBbyJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) {
        String contacts = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.city, Another_Info.adress from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id";

        String dateofBirthOfUnmarried = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.birthdate from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id " +
                "where Another_info.marital_status = 'unmarried'";

        String managerBirthday = "select Personnel.pers_ID, Personnel.name, Personnel.surname, Personnel.phone, " +
                "Another_Info.birthdate from Personnel join Another_Info on Personnel.pers_ID = Another_Info.id " +
                "join Salary on Personnel.pers_ID = Salary.id where Salary.position = 'manager'";

        registerDriver();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("----------------------------------------------------------------");
            System.out.println("Contact numbers and addresses of all workers: ");
            System.out.println("--------------------");
            statement = connection.prepareStatement(contacts);

            ResultSet resultSet1 = statement.executeQuery();
            while (resultSet1.next()){
                int pers_ID = resultSet1.getInt("pers_ID");
                String name = resultSet1.getString("name");
                String surname = resultSet1.getString("surname");
                String phone = resultSet1.getString("phone");
                String city = resultSet1.getString("city");
                String adress = resultSet1.getString("adress");

                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + city + ", " +
                        adress + ".");

            }
            System.out.println("----------------------------------------------------------------");
            System.out.println("Info about birth date of all unmarried workers: ");
            System.out.println("--------------------");
            statement = connection.prepareStatement(dateofBirthOfUnmarried);
            ResultSet resultSet2 = statement.executeQuery();
            while (resultSet2.next()){
                int pers_ID = resultSet2.getInt("pers_ID");
                String name = resultSet2.getString("name");
                String surname = resultSet2.getString("surname");
                String phone = resultSet2.getString("phone");
                Date birthdate = resultSet2.getDate("birthdate");
                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + birthdate + ".");
            }
            System.out.println("----------------------------------------------------------------");
            System.out.println("Info about all managers of the company: ");
            System.out.println("--------------------");
            statement = connection.prepareStatement(managerBirthday);
            ResultSet resultSet3 = statement.executeQuery();
            while (resultSet3.next()){
                int pers_ID = resultSet3.getInt("pers_ID");
                String name = resultSet3.getString("name");
                String surname = resultSet3.getString("surname");
                String phone = resultSet3.getString("phone");
                Date birthdate = resultSet3.getDate("birthdate");
                System.out.println(pers_ID + " " + name + " " + surname + " " + phone + " " + birthdate + ".");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }
    public static void registerDriver (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("....Driver has successfully loaded!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
