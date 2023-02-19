package hw2.task1;

class Account {
    static final double USDtoUAH = 37.45;
    static final double EURtoUAH = 40.48;
    private String accountNumber;
    private String currency;
    private double balance;
    private double balanceInUAH;
    private String type;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) throws Exception {
        if (currency.equalsIgnoreCase("USD") || currency.equalsIgnoreCase("EUR")) {
            if (balance < 0) {
                throw new Exception("not allowed balance...");

            }
        } this.balance = balance;
         if (balance < -50000) {
             throw new Exception("not allowed balance...");
        } else this.balance = balance;
    }

    public void setBalanceInUAH() {
        if (currency.equalsIgnoreCase("USD")){
            balanceInUAH = balance * USDtoUAH;
        }else
        if (currency.equalsIgnoreCase("EUR")){
            balanceInUAH = balance * EURtoUAH;
        }else
        if (currency.equalsIgnoreCase("UAH")){
            balanceInUAH = balance;
        }
    }

    public String setType() {
        if (balance < 0) {
            return  type = "Credit";
        } else
            return type = "Debit";
    }

    public void setCurrency(String currency) {
        if (currency.equalsIgnoreCase("USD") ||
                currency.equalsIgnoreCase("EUR") ||
                currency.equalsIgnoreCase("UAH")) {
            this.currency = currency;
        } else
            System.out.println("You are not allowed to open the account in another currency.");
    }

    public void status(String status) {
        if (status.equalsIgnoreCase("block")) {
            System.out.println("Account is blocked!");
        } else if (status.equalsIgnoreCase("unblock")) {
            System.out.println("Account is active!");
        } else {
            System.out.println("Incorrect status.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
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

    @Override
    public String toString() {
        return "(" + type +") " + accountNumber + "...balance = " + balance + " (" + currency + ") --- equivalent to UAH = " +
                balanceInUAH;
    }
}
