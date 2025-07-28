package app;

import java.util.List;
import java.util.Scanner;
import app.splitwise.Splitwise;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Splitwise splitwise = null;

        while (true) {
            System.out.println("\n--- Splitwise Menu ---");
            System.out.println("1. Create new Splitwise group");
            System.out.println("2. Add spending");
            System.out.println("3. Show spending");
            System.out.println("4. Show settlements");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name of person: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter amount spent: ");
                    float amount = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    splitwise = new Splitwise(name, amount);
                    System.out.println("New Splitwise group created.");
                    break;

                case 2:
                    if (splitwise == null) {
                        System.out.println("Please create a Splitwise group first.");
                        break;
                    }
                    System.out.print("Enter name of person: ");
                    String spender = scanner.nextLine();
                    System.out.print("Enter amount spent: ");
                    float spent = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    splitwise.addSpending(spender, spent);
                    System.out.println("Spending added.");
                    break;

                case 3:
                    if (splitwise == null) {
                        System.out.println("Please create a Splitwise group first.");
                        break;
                    }
                    System.out.println("\n--- Spending Details ---");
                    System.out.print(splitwise.showSpending());
                    break;

                case 4:
                    if (splitwise == null) {
                        System.out.println("Please create a Splitwise group first.");
                        break;
                    }
                    System.out.println("\n--- Settlements ---");
                    List<String> settlements = splitwise.getSettlements();
                    if (settlements.isEmpty()) {
                        System.out.println("No settlements needed. Everyone is even.");
                    } else {
                        for (String s : settlements) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
