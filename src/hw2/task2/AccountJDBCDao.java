package hw2.task2;

import hw2.task1.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class AccountJDBCDao implements AccountDAO {

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientbanking", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void add(Account account) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO accounts (accountNumber, currency, balance, balanceInUAH," +
                    "type, block) values (?, ?, ?, ?, ?, ?)");
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
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT a.accountNumber, a.currency, a.balance," +
                    "a.balanceInUAH, a.type, a.block FROM accounts as a");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                String block = rs.getString(6);
                Account account = new Account(accountNumber);
                account.setCurrency(currency);
                account.setBalance(balance);
                account.setBalanceInUAH();
                account.setType();
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("select accountNumber, currency, balance, balanceInUAH, " +
                    "type from accounts where currency = ?");
            preparedStatement.setString(1, currency);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency2 = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                Account account = new Account(accountNumber);
                account.setCurrency(currency2);
                account.setBalance(balance);
                account.setBalanceInUAH();
                account.setType();
                accountsByCurrency.add(account);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && preparedStatement != null) {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return accountsByCurrency;
    }

    @Override
    public List<Account> searchByBalance(double balance) {
        List<Account> accountsByBalance = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("select accountNumber, currency, balance, balanceInUAH," +
                    "type from accounts where balanceInUAH >= ?");
            preparedStatement.setDouble(1, balance);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance2 = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type = rs.getString(5);
                Account account = new Account(accountNumber);
                account.setCurrency(currency);
                account.setBalance(balance2);
                account.setBalanceInUAH();
                account.setType();
                accountsByBalance.add(account);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && preparedStatement != null) {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return accountsByBalance;

    }

    @Override
    public List<Account> searchByType(String type) {
        List<Account> accountsByType = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("select accountNumber, currency, balance, balanceInUAH," +
                    "type from accounts where type = ?");
            preparedStatement.setString(1, type);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString(1);
                String currency = rs.getString(2);
                double balance = rs.getDouble(3);
                double balanceInUAH = rs.getDouble(4);
                String type2 = rs.getString(5);
                Account account = new Account(accountNumber);
                account.setCurrency(currency);
                account.setBalance(balance);
                account.setBalanceInUAH();
                account.setType();
                accountsByType.add(account);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && preparedStatement != null) {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return accountsByType;
    }

    @Override
    public double amountBalance() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        double sum = 0;
        try {
            preparedStatement = connection.prepareStatement("select SUM(balanceInUAH) from accounts");
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        double sum = 0;
        try {
            preparedStatement = connection.prepareStatement("select SUM(balanceInUAH) from accounts " +
                    "where type = 'debit'");
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        double sum = 0;
        try {
            preparedStatement = connection.prepareStatement("select SUM(balanceInUAH) from accounts " +
                    "where type = 'credit'");
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
