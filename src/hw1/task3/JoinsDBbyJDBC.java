package hw1.task3;

class JoinsDBbyJDBC {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        JoinsDBbyJDBCQueries.getAllPhoneAndAdress();
        System.out.println("----------------------------------------------------------------");
        JoinsDBbyJDBCQueries.getBirthdateAllUnmarried();
        System.out.println("----------------------------------------------------------------");
        JoinsDBbyJDBCQueries.getAllManagersBirthdateAndPhone();
        System.out.println("----------------------------------------------------------------");
    }
}