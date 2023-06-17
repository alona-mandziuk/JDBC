package hw2.task1.Bank;

import hw2.task1.Currency;

public class AccountService {
    static public double setAccBalance(Account account, double balance) throws Exception {
        if (account.accountCurrency.equalsIgnoreCase("USD") ||
                account.accountCurrency.equalsIgnoreCase("EUR")) {
            if (balance < 0) {
                throw new Exception("not allowed balance in this currency");
            }

        }
        account.balance = balance;
        if (balance < -50000) {
            throw new Exception("not allowed balance...");
        } else account.balance = balance;

        return account.getBalance();
    }

    static public String setAccCurrency(Account account, String currency) {

        if (currency.equalsIgnoreCase("USD") ||
                currency.equalsIgnoreCase("EUR") ||
                currency.equalsIgnoreCase("UAH")) {
            account.accountCurrency = currency;
        } else
            System.out.println("You are not allowed to open the account in another currency.");
        return account.getCurrency();
    }

    static public double setBalanceInUAH(Account account) {
        if (account.accountCurrency.equalsIgnoreCase("USD")) {
            account.balanceInUAH = account.balance * Currency.USDtoUAH.getValue();
        } else if (account.accountCurrency.equalsIgnoreCase("EUR")) {
            account.balanceInUAH = account.balance * Currency.EURtoUAH.getValue();
        } else if (account.accountCurrency.equalsIgnoreCase("UAH")) {
            account.balanceInUAH = account.balance;
        }
        return account.getBalanceInUAH();
    }

    static public String setType(Account account) {
        if (account.balance < 0) {
            return account.type = "Credit";
        } else
            return account.type = "Debit";
    }
}
