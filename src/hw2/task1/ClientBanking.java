package hw2.task1;

import java.util.ArrayList;

class ClientBanking {
    public static void main(String[] args) throws Exception {
        ArrayList<Account> accounts = new ArrayList<>();
        Account uah = new Account("5168757542421212");
        uah.setCurrency("UAH");
        uah.setBalance(21205);
        uah.setBalanceInUAH();
        uah.setType();
        accounts.add(uah);

        Account usd = new Account("4149523678965412");
        usd.setCurrency("USD");
        usd.setBalance(12000);
        usd.setBalanceInUAH();
        usd.setType();
        accounts.add(usd);

        Account eur = new Account("4545121236367878");
        eur.setCurrency("EUR");
        eur.setBalance(5000);
        eur.setBalanceInUAH();
        eur.setType();
        accounts.add(eur);

        Account creditUAH = new Account("5252565685857474");
        creditUAH.setCurrency("UAH");
        creditUAH.setBalance(-12524.44);
        creditUAH.setBalanceInUAH();
        creditUAH.setType();
        accounts.add(creditUAH);

        for (Account a : accounts) {
            System.out.println(a);

        }
        System.out.println("-----------------------------------------");
        System.out.println("---GET INFO ABOUT YOUR ACCOUNTS, SELECT THE ACTION---");
        System.out.println("1. Show all accounts.");
        System.out.println("2. Sort by sum growth.");
        System.out.println("3. Search by the minimum input balance.");
        System.out.println("4. Search by input currency.");
        System.out.println("5. Search by account type: Credit or Debit.");
        System.out.println("6. Show amount balance.");
        System.out.println("7. Show the amount of positive-balanced accounts.");
        System.out.println("8. Show the amount of negative-balanced accounts.");
        System.out.println("Press E for Exit.");

//searchByBalance(10000, accounts);
//searchByCurrency("Uah", accounts);  //+
//searchByType("credit", accounts); //+
//        amountBalance(accounts);//+
//creditAccountBalance(accounts);
     //   debitAccountBalance(accounts);
//        sortBySum(accounts);

    }

    static final double USDtoUAH = 37.45;
    static final double EURtoUAH = 40.48;

    static void searchByCurrency(String currency, ArrayList<Account> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
            if (currency.equalsIgnoreCase(accounts.get(i).getCurrency())) {
                System.out.println(accounts.get(i));
            }
        }
    }

    static void searchByBalance(double balance, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (balance <+ accounts.get(i).getBalanceInUAH()) {
                System.out.println(accounts.get(i));
            }
        }
    }

    static void searchByType(String type, ArrayList<Account> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
            if (type.equalsIgnoreCase(accounts.get(i).getType())) {
                System.out.println(accounts.get(i));
            }
        }
    }

    static void amountBalance(ArrayList<Account> accounts) {
        double amount1 = 0;
        double amount2 = 0;
        double amount3 = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getCurrency().equalsIgnoreCase("UAH")) {
                amount1 += accounts.get(i).getBalance();
            }
            if (accounts.get(i).getCurrency().equalsIgnoreCase("USD")) {
                double am1 = 0;
                am1 += accounts.get(i).getBalance();
                amount2 = am1 * USDtoUAH;
            }
            if (accounts.get(i).getCurrency().equalsIgnoreCase("EUR")) {
                double am2 = 0;
                am2 += accounts.get(i).getBalance();
                amount3 = am2 * EURtoUAH;
            }

        }
        double amount = amount1 + amount2 + amount3;
        System.out.println("Total balance is ..... " + amount);
    }

    static void debitAccountBalance(ArrayList<Account> accounts) {
        double amount1 = 0;
        double amount2 = 0;
        double amount3 = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getType().equalsIgnoreCase("Debit")) {
                if (accounts.get(i).getCurrency().equalsIgnoreCase("UAH")) {
                    amount1 += accounts.get(i).getBalance();
                }
                if (accounts.get(i).getCurrency().equalsIgnoreCase("USD")) {
                    double am1 = 0;
                    am1 += accounts.get(i).getBalance();
                    amount2 = am1 * USDtoUAH;
                }
                if (accounts.get(i).getCurrency().equalsIgnoreCase("EUR")) {
                    double am2 = 0;
                    am2 += accounts.get(i).getBalance();
                    amount3 = am2 * EURtoUAH;
                }
            }
        }
        double amount = amount1 + amount2 + amount3;
        System.out.println("Total balance is ..... " + amount);
    }

    static void creditAccountBalance(ArrayList<Account> accounts) {
        double amount = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getType().equalsIgnoreCase("Credit")) {
                amount += accounts.get(i).getBalance();
            }
        }
        System.out.println("The total balance of credit account....." + amount);
    }

    static void sortBySum(ArrayList<Account> accounts) {
        accounts.sort((a1, a2) -> (int) (a1.getBalanceInUAH() - a2.getBalanceInUAH()));
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
