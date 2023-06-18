package hw2.task2;

import hw2.task1.Bank.Account;
import hw2.task1.Bank.AccountService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class AccountJDBCDao implements AccountDAO {
    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(System.getenv("URL"),
                    System.getenv("USER"), System.getenv("PASSWORD"));
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void add(Account account) {

        try (PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO accounts (accountNumber, currency, balance, balanceInUAH," +
                        "type, block) values (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, account.getAccountNumber());
            statement.setString(2, account.getCurrency());
            statement.setDouble(3, account.getBalance());
            statement.setDouble(4, account.getBalanceInUAH());
            statement.setString(5, account.getType());
            statement.setBoolean(6, account.isBlock());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAll() {
        List<Account> allAccounts = new ArrayList<>();

        try (PreparedStatement statement = getConnection()
                .prepareStatement("SELECT a.accountNumber, a.currency, a.balance," +
                        "a.balanceInUAH, a.type, a.block FROM accounts as a")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                boolean block = rs.getBoolean(6);
                Account account = new Account(accountNumber);
                AccountService.setAccCurrency(account, currency);
                AccountService.setAccBalance(account, balance);
                AccountService.setBalanceInUAH(account);
                AccountService.setType(account);
                account.setBlock(block);
                allAccounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAccounts;
    }

    @Override
    public List<Account> searchByCurrency(String currency) {
        List<Account> accountsByCurrency = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select accountNumber, currency, balance, balanceInUAH, " +
                        "type from accounts where currency = ?")) {
            preparedStatement.setString(1, currency);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency2 = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                Account account = new Account(accountNumber);
                AccountService.setAccCurrency(account, currency2);
                AccountService.setAccBalance(account, balance);
                AccountService.setBalanceInUAH(account);
                AccountService.setType(account);
                accountsByCurrency.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountsByCurrency;
    }

    @Override
    public List<Account> searchByBalance(double balance) {
        List<Account> accountsByBalance = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select accountNumber, currency, balance, balanceInUAH," +
                        "type from accounts where balanceInUAH >= ?")) {
            preparedStatement.setDouble(1, balance);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance2 = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                Account account = new Account(accountNumber);
                AccountService.setAccCurrency(account, currency);
                AccountService.setAccBalance(account, balance2);
                AccountService.setBalanceInUAH(account);
                AccountService.setType(account);
                accountsByBalance.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountsByBalance;
    }

    @Override
    public List<Account> searchByType(String type) {
        List<Account> accountsByType = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select accountNumber, currency, balance, balanceInUAH," +
                        "type from accounts where type = ?")) {
            preparedStatement.setString(1, type);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type2 = rs.getString(5);
                Account account = new Account(accountNumber);
                AccountService.setAccCurrency(account, currency);
                AccountService.setAccBalance(account, balance);
                AccountService.setBalanceInUAH(account);
                AccountService.setType(account);
                accountsByType.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountsByType;
    }

    @Override
    public double amountBalance() {
        double sum = 0;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select SUM(balanceInUAH) from accounts")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public double debitAccountBalance() {
        double sum = 0;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select SUM(balanceInUAH) from accounts " +
                        "where type = 'debit'")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;

    }

    @Override
    public double creditAccountBalance() {
        double sum = 0;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("select SUM(balanceInUAH) from accounts " +
                        "where type = 'credit'")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sum = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
