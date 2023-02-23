package hw2.task2;

import hw2.task1.Account;

import java.util.ArrayList;
import java.util.List;


interface AccountDAO {
    void add (Account account);
    List<Account> getAll();
    void searchByCurrency(String currency);
    void searchByBalance(double balance);
    void searchByType(String type);
    void amountBalance(List<Account> accounts);
    void debitAccountBalance(List<Account> accounts);
    void creditAccountBalance(List<Account> accounts);
    void sortBySum(List<Account> accounts);

}
