package hw2.task2;

import hw2.task1.Bank.Account;

import java.util.List;


interface AccountDAO {
    void add(Account account);

    List<Account> getAll();

    List<Account> searchByCurrency(String currency);

    List<Account> searchByBalance(double balance);

    List<Account> searchByType(String type);

    double amountBalance();

    double debitAccountBalance();

    double creditAccountBalance();

}
