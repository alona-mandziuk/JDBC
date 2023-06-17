//package hw2.task2;
//
//class DAOFactory implements IDAOFactory {
//
//    private static IDAOFactory factory;
//
//    private DAOFactory() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("...Driver has loaded successfully!");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static synchronized IDAOFactory getInstance() {
//        if (factory == null) {
//            factory = new DAOFactory();
//        }
//        return factory;
//    }
//
//    @Override
//    public AccountDAO getAccountDao() {
//        return new AccountJDBCDao();
//    }
//}
