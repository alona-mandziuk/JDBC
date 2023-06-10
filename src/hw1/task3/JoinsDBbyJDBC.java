package hw1.task3;
class JoinsDBbyJDBC {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Contact numbers and addresses of all workers: ");
        System.out.println("--------------------");
        JoinsDBbyJDBCQueries.getAllPhoneAndAdress();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Info about birth date of all unmarried workers: ");
        System.out.println("--------------------");
        JoinsDBbyJDBCQueries.getBirthdateAllUnmarried();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Info about all managers of the company: ");
        System.out.println("--------------------");
        JoinsDBbyJDBCQueries.getAllManagersBirthdateAndPhone();
        System.out.println("----------------------------------------------------------------");


    }
}