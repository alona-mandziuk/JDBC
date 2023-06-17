package hw2.task1;

import hw2.task1.Bank.Account;
import hw2.task1.Bank.AccountService;
import java.util.ArrayList;
import java.util.List;

class ClientAccounts {

    static List<Account> all() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Account uah = new Account("5168757542421212");
        AccountService.setAccCurrency(uah, "UAH");
        AccountService.setAccBalance(uah, 21205);
        AccountService.setBalanceInUAH(uah);
        AccountService.setType(uah);
        uah.setBlock(false);
        accounts.add(uah);

        Account usd = new Account("4149523678965412");
        AccountService.setAccCurrency(usd, "USD");
        AccountService.setAccBalance(usd, 12000);
        AccountService.setBalanceInUAH(usd);
        AccountService.setType(usd);
        usd.setBlock(false);
        accounts.add(usd);

        Account eur = new Account("4545121236367878");
        AccountService.setAccCurrency(eur, "EUR");
        AccountService.setAccBalance(eur, 5000);
        AccountService.setBalanceInUAH(eur);
        AccountService.setType(eur);
        eur.setBlock(true);
        accounts.add(eur);

        Account creditUAH = new Account("5252565685857474");
        AccountService.setAccCurrency(creditUAH, "UAH");
        AccountService.setAccBalance(creditUAH, -12524.44);
        AccountService.setBalanceInUAH(creditUAH);
        AccountService.setType(creditUAH);
        creditUAH.setBlock(false);
        accounts.add(creditUAH);
        return accounts;
    }
}
