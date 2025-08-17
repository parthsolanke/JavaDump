package tutorial;

public class Loops {
    public static void main(String[] args) {
        // -------------------------------
        // FOR LOOP
        // -------------------------------
        // Purpose: Ideal when the number of repetitions is known.
        // Components:
        //   1. Initialization (runs once before loop starts)
        //   2. Condition (checked before each iteration; loop continues while true)
        //   3. Iteration (runs after each loop body execution)
        // Usage: Traversing arrays, repeating fixed number of times.
        for (int i = 0; i < 5; i++) {
            System.out.println("For loop iteration: " + i);
        }
        // Output:
        // For loop iteration: 0
        // For loop iteration: 1
        // For loop iteration: 2
        // For loop iteration: 3
        // For loop iteration: 4


        // -------------------------------
        // ENHANCED FOR LOOP (for-each)
        // -------------------------------
        // Purpose: Iterate over collections/arrays without needing an index.
        // Note: Read-only; you cannot modify the collection structure during iteration.
        int[] numbers = {10, 20, 30, 40};
        for (int num : numbers) {
            System.out.println("Enhanced for loop value: " + num);
        }
        // Output:
        // Enhanced for loop value: 10
        // Enhanced for loop value: 20
        // Enhanced for loop value: 30
        // Enhanced for loop value: 40


        // -------------------------------
        // WHILE LOOP
        // -------------------------------
        // Purpose: Repeat while a condition is true.
        // Condition checked BEFORE each iteration.
        // If condition is false initially, loop body may never execute.
        int count = 0;
        while (count < 3) {
            System.out.println("While loop count: " + count);
            count++; // Important: update loop variable to avoid infinite loop
        }
        // Output:
        // While loop count: 0
        // While loop count: 1
        // While loop count: 2


        // -------------------------------
        // DO-WHILE LOOP
        // -------------------------------
        // Purpose: Similar to while, BUT always executes body at least once,
        // because condition is checked AFTER the loop body.
        int i = 5;
        do {
            System.out.println("Do-while loop i: " + i);
            i++;
        } while (i < 3);
        // Output:
        // Do-while loop i: 5   (runs once even though condition was false at start)


        // -------------------------------
        // JUMP STATEMENTS
        // -------------------------------

        // break: exits the innermost loop immediately
        for (int j = 0; j < 5; j++) {
            if (j == 3) {
                break; // exit loop when j == 3
            }
            System.out.println("Break example, j = " + j);
        }
        // Output:
        // Break example, j = 0
        // Break example, j = 1
        // Break example, j = 2

        // continue: skips the rest of current iteration, moves to next
        for (int j = 0; j < 5; j++) {
            if (j % 2 == 0) {
                continue; // skip even numbers
            }
            System.out.println("Continue example, j = " + j);
        }
        // Output:
        // Continue example, j = 1
        // Continue example, j = 3

        // return: exits the current method entirely
        System.out.println("Return example begins");
        if (true) {
            return; // exits main() here, no further code executes
        }
        // System.out.println("This line will never run!");
    }
}