package hw2.task1;
class ClientBanking {
    public static void main(String[] args) {
        try {
            AccManipulate.chooseTheActionWithAccount(ClientAccounts.all());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
