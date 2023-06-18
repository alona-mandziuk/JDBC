package hw2.task2;

class Main {
    public static void main(String[] args) {
        try {
            ClientAccountsDAO.clientManipulate(ClientAccountsDAO.allDAO());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
