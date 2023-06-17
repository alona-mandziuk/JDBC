package hw2.task1;

import java.util.ArrayList;
import java.util.List;

public class ClientAccounts extends Account {

    static List <Account> all () throws Exception {
        List<Account> accounts = new ArrayList<>();
        Account uah = new Account("5168757542421212");
        uah.setCurrency("UAH");
        uah.setBalance(21205);
        uah.setBalanceInUAH();
        uah.setType();
        uah.setBlock(false);
        accounts.add(uah);

        Account usd = new Account("4149523678965412");
        usd.setCurrency("USD");
        usd.setBalance(12000);
        usd.setBalanceInUAH();
        usd.setType();
        usd.setBlock(false);
        accounts.add(usd);

        Account eur = new Account("4545121236367878");
        eur.setCurrency("EUR");
        eur.setBalance(5000);
        eur.setBalanceInUAH();
        eur.setType();
        eur.setBlock(true);
        accounts.add(eur);

        Account creditUAH = new Account("5252565685857474");
        creditUAH.setCurrency("UAH");
        creditUAH.setBalance(-12524.44);
        creditUAH.setBalanceInUAH();
        creditUAH.setType();
        creditUAH.setBlock(false);
        accounts.add(creditUAH);
        return accounts;
    }
}
