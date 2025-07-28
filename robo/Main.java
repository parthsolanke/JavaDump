import java.util.Scanner;

import core.Robo;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter robot commands (e.g., LRFRF): ");
        String input = sc.nextLine().toUpperCase();

        Robo robo = new Robo();
        robo.processInput(input);
        robo.showPosition();
        sc.close();
    }
}