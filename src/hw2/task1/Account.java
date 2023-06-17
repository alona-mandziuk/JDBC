package hw2.task1;

public class Account {

    private String accountNumber;
    private String accountCurrency;
    private double balance;
    private double balanceInUAH;
    private String type;
    private boolean block;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }



    public void setBalance(double balance) throws Exception {
        if (accountCurrency.equalsIgnoreCase("USD") || accountCurrency.equalsIgnoreCase("EUR")) {
            if (balance < 0) {
                throw new Exception("not allowed balance in this currency");
            }
        }
        this.balance = balance;
        if (balance < -50000) {
            throw new Exception("not allowed balance...");
        } else this.balance = balance;
    }

    public void setBalanceInUAH() {
        if (accountCurrency.equalsIgnoreCase("USD")) {
            balanceInUAH = balance * Currency.USDtoUAH.getValue();
        } else if (accountCurrency.equalsIgnoreCase("EUR")) {
            balanceInUAH = balance * Currency.EURtoUAH.getValue();
        } else if (accountCurrency.equalsIgnoreCase("UAH")) {
            balanceInUAH = balance;
        }
    }

    public String setType() {
        if (balance < 0) {
            return type = "Credit";
        } else
            return type = "Debit";
    }

    public void setCurrency(String accountCurrency) {
        if (accountCurrency.equalsIgnoreCase("USD") ||
                accountCurrency.equalsIgnoreCase("EUR") ||
                accountCurrency.equalsIgnoreCase("UAH")) {
            this.accountCurrency = accountCurrency;
        } else
            System.out.println("You are not allowed to open the account in another currency.");
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return accountCurrency;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public double getBalanceInUAH() {
        return balanceInUAH;
    }

    public boolean isBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "(" + type + ") " + accountNumber + "...balance = " + balance + " (" + accountCurrency + ") --- equivalent to UAH = " +
                balanceInUAH + " [block: " + block + "]";
    }
}
