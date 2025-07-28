package oop;
import oop.Abstraction.SavingsAcc;
import oop.Encapsulation.BankAcc;
import oop.Inheritance.CurrentAcc;

public class Main {
    public static void main(String[] args) {
        BankAcc acc = new BankAcc("parth", 1000);
        System.out.println(acc.getBalance());

        SavingsAcc savingsAcc = new SavingsAcc("solanke", 2000);
        System.out.println("Holder: " + savingsAcc.getAccountHolder());
        System.out.println("Initial Balance: " + savingsAcc.getBalance());

        savingsAcc.deposit(300);
        savingsAcc.withdraw(100);

        System.out.println("Final Balance: " + savingsAcc.getBalance());

        CurrentAcc current = new CurrentAcc("Parth", 1000, 500);
        current.withdraw(1200);  // allowed due to overdraft
        System.out.println("Current Balance: " + current.getBalance());
    }
}
