package oop.Abstraction;

public interface Acc {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getAccountHolder();
}