//package hw2.task2;
//
//import hw2.task1.Account;
//import java.util.Iterator;
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) throws Exception {
//        IDAOFactory factory = DAOFactory.getInstance();
//        AccountDAO accountDAO = factory.getAccountDao();
//        Account uah = new Account("5168757542421212");
//        uah.setCurrency("UAH");
//        uah.setBalance(21205);
//        uah.setBalanceInUAH();
//        uah.setType();
//        uah.setBlock("unblock");
//        accountDAO.add(uah);
//
//        Account usd = new Account("4149523678965412");
//        usd.setCurrency("USD");
//        usd.setBalance(12000);
//        usd.setBalanceInUAH();
//        usd.setType();
//        usd.setBlock("unblock");
//        accountDAO.add(usd);
//
//        Account eur = new Account("4545121236367878");
//        eur.setCurrency("EUR");
//        eur.setBalance(5000);
//        eur.setBalanceInUAH();
//        eur.setType();
//        eur.setBlock("unblock");
//        accountDAO.add(eur);
//
//        Account creditUAH = new Account("5252565685857474");
//        creditUAH.setCurrency("UAH");
//        creditUAH.setBalance(-12524.44);
//        creditUAH.setBalanceInUAH();
//        creditUAH.setType();
//        creditUAH.setBlock("unblock");
//        accountDAO.add(creditUAH);
//
//        System.out.println("---------------------------------------------");
//        System.out.println("---GET INFO ABOUT YOUR ACCOUNTS, SELECT THE ACTION---");
//        System.out.println("1. Show all accounts.");
//        System.out.println("2. Search by the minimum input balance.");
//        System.out.println("3. Search by input currency.");
//        System.out.println("4. Search by account type: Credit or Debit.");
//        System.out.println("5. Show amount balance.");
//        System.out.println("6. Show the amount of positive-balanced accounts.");
//        System.out.println("7. Show the amount of negative-balanced accounts.");
//        System.out.println("8. To Exit.");
//        System.out.println("----------------------------------------------");
//        while (true) {
//            System.out.println("Chose: ");
//            Scanner scanner = new Scanner(System.in);
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    Iterator<Account> accountIterator = accountDAO.getAll().iterator();
//                    while (accountIterator.hasNext()) {
//                        System.out.println(accountIterator.next());
//                    }
//                    break;
//                case 2:
//                    System.out.println("Input the sum: ");
//                    Scanner scanner1 = new Scanner(System.in);
//                    double minSum = scanner1.nextDouble();
//                    Iterator<Account> accountIterator2 = accountDAO.searchByBalance(minSum).iterator();
//                    while (accountIterator2.hasNext()) {
//                        System.out.println(accountIterator2.next());
//                    }
//                    break;
//                case 3:
//                    System.out.println("Input the currency (UAH, USD, EUR): ");
//                    Scanner scanner2 = new Scanner(System.in);
//                    String inputCurrency = scanner2.next();
//                    Iterator<Account> accountIterator3 = accountDAO.searchByCurrency(inputCurrency).iterator();
//                    while (accountIterator3.hasNext()) {
//                        System.out.println(accountIterator3.next());
//                    }
//                    break;
//                case 4:
//                    System.out.println("Input the account type (debit / credit): ");
//                    Scanner scanner3 = new Scanner(System.in);
//                    String inputType = scanner3.next();
//                    Iterator<Account> accountIterator4 = accountDAO.searchByType(inputType).iterator();
//                    while (accountIterator4.hasNext()) {
//                        System.out.println(accountIterator4.next());
//                    }
//                    break;
//                case 5:
//
//                    System.out.println("Amount balance: " + accountDAO.amountBalance());
//                    break;
//                case 6:
//                    System.out.println("Debit accounts balance: " + accountDAO.debitAccountBalance());
//                    break;
//                case 7:
//                    System.out.println("Credit accounts balance: " + accountDAO.creditAccountBalance());
//                    break;
//
//            }
//            if (choice == 8) {
//                System.out.println("---------------------------");
//                System.out.println("Finish!");
//                break;
//            }
//        }
//    }
//}
