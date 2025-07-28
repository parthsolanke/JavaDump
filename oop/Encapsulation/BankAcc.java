package oop.Encapsulation;

public class BankAcc {
    protected String accountHolder;
    protected double balance;

    // Constructor
    public BankAcc(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccHolder() {
        return accountHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accountHolder = accHolder;
    }

    public double getBalance() {
        return balance;
    }

    // public methods
    public void deposit(double amount) {
        if ( amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if ( amount > 0 && amount <= balance) {
            this.balance -= amount;
        }
    }

}
