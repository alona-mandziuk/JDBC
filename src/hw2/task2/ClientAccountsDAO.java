package hw2.task2;

import hw2.task1.Bank.Account;
import hw2.task1.Bank.AccountService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class ClientAccountsDAO {
    static AccountDAO allDAO() throws Exception {
        List<Account> accounts = new ArrayList<>();
        IDAOFactory factory = DAOFactory.getInstance();
        AccountDAO accountDAO = factory.getAccountDao();
        Account uah = new Account("5168757542421212");
        AccountService.setAccCurrency(uah, "UAH");
        AccountService.setAccBalance(uah, 21205);
        AccountService.setBalanceInUAH(uah);
        AccountService.setType(uah);
        uah.setBlock(false);
        accountDAO.add(uah);

        Account usd = new Account("4149523678965412");
        AccountService.setAccCurrency(usd, "USD");
        AccountService.setAccBalance(usd, 12000);
        AccountService.setBalanceInUAH(usd);
        AccountService.setType(usd);
        usd.setBlock(false);
        accountDAO.add(usd);

        Account eur = new Account("4545121236367878");
        AccountService.setAccCurrency(eur, "EUR");
        AccountService.setAccBalance(eur, 5000);
        AccountService.setBalanceInUAH(eur);
        AccountService.setType(eur);
        eur.setBlock(true);
        accountDAO.add(eur);

        Account creditUAH = new Account("5252565685857474");
        AccountService.setAccCurrency(creditUAH, "UAH");
        AccountService.setAccBalance(creditUAH, -12524.44);
        AccountService.setBalanceInUAH(creditUAH);
        AccountService.setType(creditUAH);
        creditUAH.setBlock(false);
        accountDAO.add(creditUAH);
        return accountDAO;
    }

    static void clientManipulate (AccountDAO accountDAO){
        System.out.println("---------------------------------------------");
        System.out.println("---GET INFO ABOUT YOUR ACCOUNTS, SELECT THE ACTION---");
        System.out.println("1. Show all accounts.");
        System.out.println("2. Search by the minimum input balance.");
        System.out.println("3. Search by input currency.");
        System.out.println("4. Search by account type: Credit or Debit.");
        System.out.println("5. Show amount balance.");
        System.out.println("6. Show the amount of positive-balanced accounts.");
        System.out.println("7. Show the amount of negative-balanced accounts.");
        System.out.println("8. To Exit.");
        System.out.println("----------------------------------------------");
        while (true) {
            System.out.println("Chose: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Iterator<Account> accountIterator = accountDAO.getAll().iterator();
                    while (accountIterator.hasNext()) {
                        System.out.println(accountIterator.next());
                    }
                    break;
                case 2:
                    System.out.println("Input the sum: ");
                    Scanner scanner1 = new Scanner(System.in);
                    double minSum = scanner1.nextDouble();
                    Iterator<Account> accountIterator2 = accountDAO.searchByBalance(minSum).iterator();
                    while (accountIterator2.hasNext()) {
                        System.out.println(accountIterator2.next());
                    }
                    break;
                case 3:
                    System.out.println("Input the currency (UAH, USD, EUR): ");
                    Scanner scanner2 = new Scanner(System.in);
                    String inputCurrency = scanner2.next();
                    Iterator<Account> accountIterator3 = accountDAO.searchByCurrency(inputCurrency).iterator();
                    while (accountIterator3.hasNext()) {
                        System.out.println(accountIterator3.next());
                    }
                    break;
                case 4:
                    System.out.println("Input the account type (debit / credit): ");
                    Scanner scanner3 = new Scanner(System.in);
                    String inputType = scanner3.next();
                    Iterator<Account> accountIterator4 = accountDAO.searchByType(inputType).iterator();
                    while (accountIterator4.hasNext()) {
                        System.out.println(accountIterator4.next());
                    }
                    break;
                case 5:

                    System.out.println("Amount balance: " + accountDAO.amountBalance());
                    break;
                case 6:
                    System.out.println("Debit accounts balance: " + accountDAO.debitAccountBalance());
                    break;
                case 7:
                    System.out.println("Credit accounts balance: " + accountDAO.creditAccountBalance());
                    break;

            }
            if (choice == 8) {
                System.out.println("---------------------------");
                System.out.println("Finish!");
                break;
            }
        }
    }
}
