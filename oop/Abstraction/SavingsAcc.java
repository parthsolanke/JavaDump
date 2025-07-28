package oop.Abstraction;

public class SavingsAcc implements Acc {
    private String accHolder;
    private double balance;

    public SavingsAcc(String accHolder, double balance) {
        this.accHolder = accHolder;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountHolder() {
        return accHolder;
    }
    
}
