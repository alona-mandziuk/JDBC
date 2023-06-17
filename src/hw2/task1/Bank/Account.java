package hw2.task1.Bank;

public class Account {

    String accountNumber;
    String accountCurrency;
    double balance;
    double balanceInUAH;
    String type;
    boolean block;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
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
