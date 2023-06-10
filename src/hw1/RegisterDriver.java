package hw1;

public class RegisterDriver {
    public static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.printf("Driver has successfully loaded!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
