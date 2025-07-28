package oop.Inheritance;

import oop.Encapsulation.BankAcc;

public class CurrentAcc extends BankAcc {
        private double overdraftLimit;

        public CurrentAcc(String accountHolder, double balance, double overdraftLimit) {
            super(accountHolder, balance); // using superclass constructor
            this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            // polymorphism
            System.out.print("Wihdrawing from Current Acc: \n");
            balance -= amount;
        }
    }
}
