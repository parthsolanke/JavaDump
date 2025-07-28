package core;

import java.util.Arrays;
import java.util.List;

public class Direction {
    private char head = 'N';
    private static final List<Character> DIRECTIONS = Arrays.asList('N', 'E', 'S', 'W');

    public void updateDirection(char command) {
        int idx = DIRECTIONS.indexOf(this.head);
        if (command == 'L') {
            idx = (idx + 3) % 4;
        } else {
            idx = (idx + 1) % 4;
        }
        this.head = DIRECTIONS.get(idx);
    }  

    public char getHead() {
        return this.head;
    }

}
