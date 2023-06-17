package hw2.task1;

import hw2.task1.Bank.Account;

import java.util.List;
import java.util.Scanner;

class AccManipulate {

    /**
     * Method gets the list of accounts and gives the user opportunity of choosing the action from console.
     */

    static void chooseTheActionWithAccount(List<Account> accounts) {
        System.out.println("---------------------------------------------");
        System.out.println("---GET INFO ABOUT YOUR ACCOUNTS, SELECT THE ACTION---");
        System.out.println("1. Show all accounts.");
        System.out.println("2. Sort by sum growth.");
        System.out.println("3. Search by the minimum input balance.");
        System.out.println("4. Search by input currency.");
        System.out.println("5. Search by account type: Credit or Debit.");
        System.out.println("6. Show amount balance.");
        System.out.println("7. Show the amount of positive-balanced accounts.");
        System.out.println("8. Show the amount of negative-balanced accounts.");
        System.out.println("9. To block/unblock account");
        System.out.println("10. To Exit.");
        System.out.println("----------------------------------------------");
        while (true) {
            System.out.println("Chose: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Account a : accounts) {
                        System.out.println(a);
                    }
                    break;
                case 2:
                    sortBySum(accounts);
                    break;
                case 3:
                    System.out.println("Input the sum: ");
                    Scanner scanner1 = new Scanner(System.in);
                    double minSum = scanner1.nextDouble();
                    searchByBalance(minSum, accounts);
                    break;
                case 4:
                    System.out.println("Input the currency (UAH, USD, EUR): ");
                    Scanner scanner2 = new Scanner(System.in);
                    String inputCurrency = scanner2.next();
                    searchByCurrency(inputCurrency, accounts);
                    break;
                case 5:
                    System.out.println("Input the account type (debit / credit): ");
                    Scanner scanner3 = new Scanner(System.in);
                    String inputType = scanner3.next();
                    searchByType(inputType, accounts);
                    break;
                case 6:
                    amountBalance(accounts);
                    break;
                case 7:
                    debitAccountBalance(accounts);
                    break;
                case 8:
                    creditAccountBalance(accounts);
                    break;
                case 9:
                    System.out.println("Input the account number:");
                    System.out.println("----------------------");
                    for (Account a : accounts) {
                        System.out.println(a);
                    }
                    System.out.println("-------------------------");
                    Scanner scanner4 = new Scanner(System.in);
                    String accountNo = scanner4.next();
                    System.out.println("Input the status (block/unblock):");
                    Scanner scanner5 = new Scanner(System.in);
                    String status = scanner5.next();
                    for (int i = 0; i < accounts.size(); i++) {
                        if (accountNo.equalsIgnoreCase(accounts.get(i).getAccountNumber())) {

                            if (status.equalsIgnoreCase("block")) {
                                accounts.get(i).setBlock(true);
                            } else if (status.equalsIgnoreCase("unblock")) {
                                accounts.get(i).setBlock(false);
                            }
                            System.out.println(accounts.get(i));
                        }
                    }
                    break;
            }
            if (choice == 10) {
                System.out.println("---------------------------");
                System.out.println("Finish!");
                break;
            }
        }
    }

    /**
     * Method searches accounts according to input currency.
     */
    static void searchByCurrency(String currency, List<Account> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
            if (currency.equalsIgnoreCase(accounts.get(i).getCurrency())) {
                System.out.println(accounts.get(i));
            }
        }
    }

    /**
     * Method searches accounts according to input balance.
     */
    static void searchByBalance(double balance, List<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (balance < +accounts.get(i).getBalanceInUAH()) {
                System.out.println(accounts.get(i));
            }
        }
    }

    /**
     * Method searches accounts according to input account type.
     */
    static void searchByType(String type, List<Account> accounts) {

        for (int i = 0; i < accounts.size(); i++) {
            if (type.equalsIgnoreCase(accounts.get(i).getType())) {
                System.out.println(accounts.get(i));
            }
        }
    }

    /**
     * Method shows amount balance on all accounts.
     */

    static void amountBalance(List<Account> accounts) {
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

                amount2 = am1 * Currency.USDtoUAH.getValue();
            }
            if (accounts.get(i).getCurrency().equalsIgnoreCase("EUR")) {
                double am2 = 0;
                am2 += accounts.get(i).getBalance();
                amount3 = am2 * Currency.EURtoUAH.getValue();
            }

        }
        double amount = amount1 + amount2 + amount3;
        System.out.println("Total balance is ..... " + amount);
    }

    /**
     * Method shows amount balance on debit accounts.
     */

    static void debitAccountBalance(List<Account> accounts) {
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
                    amount2 = am1 * Currency.USDtoUAH.getValue();
                }
                if (accounts.get(i).getCurrency().equalsIgnoreCase("EUR")) {
                    double am2 = 0;
                    am2 += accounts.get(i).getBalance();
                    amount3 = am2 * Currency.EURtoUAH.getValue();
                }
            }
        }
        double amount = amount1 + amount2 + amount3;
        System.out.println("Total balance is ..... " + amount);
    }

    /**
     * Method shows amount balance on credit accounts.
     */
    static void creditAccountBalance(List<Account> accounts) {
        double amount = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getType().equalsIgnoreCase("Credit")) {
                amount += accounts.get(i).getBalance();
            }
        }
        System.out.println("The total balance of credit account....." + amount);
    }

    /**
     * Method sorts accounts by sum.
     */
    static void sortBySum(List<Account> accounts) {
        accounts.sort((a1, a2) -> (int) (a1.getBalanceInUAH() - a2.getBalanceInUAH()));
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
